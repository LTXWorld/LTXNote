package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmdp.dto.Result;
import com.hmdp.dto.ScrollResult;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.Blog;
import com.hmdp.entity.Follow;
import com.hmdp.entity.User;
import com.hmdp.mapper.BlogMapper;
import com.hmdp.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.service.IFollowService;
import com.hmdp.service.IUserService;
import com.hmdp.utils.SystemConstants;
import com.hmdp.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.hmdp.utils.RedisConstants.BLOG_LIKED_KEY;
import static com.hmdp.utils.RedisConstants.FEED_KEY;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {
    @Resource
    private IUserService userService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private IFollowService iFollowService;

    /**
     * 根据博客id查询博客以及对应的用户信息
     * @param id
     * @return
     */
    @Override
    public Result queryBlogByID(Long id) {
        //查询blog
        Blog blog = getById(id);
        //查询blog有关的用户
        if (blog == null){
            return Result.fail("笔记不存在");
        }
        queryBlogUser(blog);
        //需要加上查询blog是否被点赞
        isBlogLiked(blog);
        return null;
    }

    private void isBlogLiked(Blog blog) {
        UserDTO user = UserHolder.getUser();
        if (user == null){
            return;
        }
        Long userId = UserHolder.getUser().getId();
        String key = "blog:liked:" + blog.getId();
        Double score =  stringRedisTemplate.opsForZSet().score(key, userId.toString());
        blog.setIsLike(score != null);//证明点过赞了
    }

    @Override
    public Result queryHotBlog(Integer current) {
        //根据用户查询
        Page<Blog> page = query()
                .orderByDesc("liked")
                .page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
        //获取当页数据
        List<Blog> records = page.getRecords();
        //查询用户,这是一个遍历过程。
        records.forEach(blog -> {
            queryBlogUser(blog);
            isBlogLiked(blog);//查询是否点过赞了
        });
        return Result.ok(records);
    }

    @Override
    public Result likeBlog(Long id) {
        //判断当前用户是否已经点赞
        Long userId = UserHolder.getUser().getId();
        String key = "blog:liked:" + id;
        Double score = stringRedisTemplate.opsForZSet().score(key, userId.toString());
        //将blogid和用户id作为key-value放入redisset集合中
        //如果未点赞，可以点赞
        if (score == null){
            //数据库点赞数+1，用户信息保存在redis集合中，为了下一次用来判断是否点过赞了
            boolean isSuccess = update().setSql("liked = liked + 1").eq("id", id).update();
            if (isSuccess){ //zadd key value score
                stringRedisTemplate.opsForZSet().add(key, userId.toString(), System.currentTimeMillis());
            }
        }else{
            //如果已经点赞，取消点赞，数据库点赞数-1，将用户从redis集合移除——因为点两次取消
            boolean isSuccess = update().setSql("liked = liked -1 ").eq("id", id).update();
            if (isSuccess){
                stringRedisTemplate.opsForZSet().remove(key, userId.toString());
            }
        }
        //
        return Result.ok();
    }


    /**
     * 返回点赞用户top5
     * @param id
     * @return
     */
    @Override
    public Result queryBlogLikes(Long id) {
        String key = BLOG_LIKED_KEY + id;
        //查询top5点赞用户 zrange key 0 4
        Set<String> top5 = stringRedisTemplate.opsForZSet().range(key, 0, 4);
        if (top5 == null || top5.isEmpty()){
            return Result.ok(Collections.emptyList());
        }
        //解析出用户id，根据id查询用户，返回用户
        List<Long> ids = top5.stream().map(Long::valueOf).collect(Collectors.toList());
        List<UserDTO> userDTOS = userService.listByIds(ids).stream()
                .map(user -> BeanUtil.copyProperties(user, UserDTO.class))
                .collect(Collectors.toList());
        //
        return Result.ok(userDTOS);
    }

    /**
     * 根据博客名称保存博客,并发送到粉丝的收件箱中
     * @param blog
     * @return
     */
    @Override
    public Result saveBlog(Blog blog) {
        //获取当前登录用户（也是写博客的用户）
        UserDTO user = UserHolder.getUser();
        blog.setUserId(user.getId());
        //保存博客到数据库
        boolean isSuccess = save(blog);
        if (! isSuccess){
            return Result.fail("新增笔记失败");
        }
        //开始推送给粉丝，但是首先需要查询当前用户的所有粉丝
        List<Follow> follows = iFollowService.query().eq("follow_user_id", user.getId()).list();
        //
        for (Follow follow : follows) {
            //获取粉丝id
            Long userId = follow.getUserId();
            //推送
            String key = "feed:" + userId;
            stringRedisTemplate.opsForZSet().add(key, blog.getId().toString(), System.currentTimeMillis());
        }
        return Result.ok(blog.getId());//返回博客的id
    }

    /**
     * 分页滚动查询
     * @param max 本次查询的最大值（也是上次查询的最小值）
     * @param offset 要查多少，偏移量
     * @return 返回一个ScrollResultDTO,里面有三个参数：博客、当前最小值、偏移量（有几个与最小值相等的）
     */
    @Override
    public Result queryBlogOfFollow(Long max, Integer offset) {
        //获取当前用户id，为了获取其信箱中的博客
        Long userId = UserHolder.getUser().getId();
        String key = FEED_KEY + userId;
        //将sortedset集合中（信箱）的键值对进行按照时间排序,即执行redis中的语句
        Set<ZSetOperations.TypedTuple<String>> typedTuples = stringRedisTemplate.opsForZSet()
                .reverseRangeByScoreWithScores(key, 0, max, offset, 2);
        //
        if (typedTuples == null || typedTuples.isEmpty()){
            return Result.ok();
        }
        //解析存入信箱中的数据，博客id，时间戳，偏移量
        //定义保存博客id的集合，时间戳偏移量的默认值
        ArrayList<Object> ids = new ArrayList<>(typedTuples.size());
        long minTime = 0;
        int of = 1;
        //举例score：5，4，4，2，2
        for (ZSetOperations.TypedTuple<String> typedTuple : typedTuples) {
            //获取博客id
            ids.add(Long.valueOf(typedTuple.getValue()));
            //获取时间戳，即sortedset集合中的分数
            long time = typedTuple.getScore().longValue();
            //根据时间戳来推断出偏移量
            if (time == minTime){
                of ++;
            }else {
                minTime = time;//每次来找到新的最小时间戳
                of = 1;
            }
        }
        //根据id查询blog
        String idStr = StrUtil.join(",", ids);
        List<Blog> blogs = query().in("id", ids)
                .last("ORDER BY FIELD(id," + idStr + ")")
                .list();
        //对每个博客进行相关操作：查询有关用户，是否被点赞
        for (Blog blog : blogs) {
            queryBlogUser(blog);
            isBlogLiked(blog);
        }
        //封装三个信息返回
        ScrollResult result = new ScrollResult();
        result.setList(blogs);
        result.setMinTime(minTime);
        result.setOffset(of);
        return Result.ok(result);
    }

    /**
     * 根据博客查询用户
     * @param blog
     */
    private void queryBlogUser(Blog blog) {
        Long userId = blog.getUserId();
        User user = userService.getById(userId);
        blog.setName(user.getNickName());
        blog.setIcon(user.getIcon());
    }
}

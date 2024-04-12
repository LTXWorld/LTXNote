package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RedisConstants;
import com.hmdp.utils.RegexUtils;
import com.hmdp.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.SystemConstants.USER_NICK_NAME_PREFIX;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {//使用到了MybatisPlus

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据手机号发送验证码
     * @param phone
     * @param session
     * @return
     */
    @Override
    public Result sendCode(String phone, HttpSession session) {
        //1校验手机号
        if (RegexUtils.isPhoneInvalid(phone)) {
            //2如果不符合返回错误信息
            return Result.fail("手机号格式错误");
        }

        //3符合，生成验证码
        String code = RandomUtil.randomNumbers(6);
        //4保存验证码到session
//        session.setAttribute("code", code);
        //新方法，保存到Redis中,键值对形式，键为手机号码，值为验证码
        stringRedisTemplate.opsForValue().set(RedisConstants.LOGIN_CODE_KEY + phone, code, RedisConstants.LOGIN_CODE_TTL, TimeUnit.MINUTES);
        //5发送验证码
        log.debug("发送成功"+code);
        return Result.ok();//返回工具类中Result的OK方法
    }

    /**
     * 登录验证
     * @param loginForm
     * @param session
     * @return
     */
    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        //1校验手机号
        String phone = loginForm.getPhone();
        if (RegexUtils.isPhoneInvalid(phone)) {
            //2如果不符合，返回错误信息
            return Result.fail("手机号格式错误");
        }
        //3校验验证码,从Redis中取出验证码
//        Object cachecode = session.getAttribute("code");//这是之前已经生成并保存在session中的验证码
        String cachecode = stringRedisTemplate.opsForValue().get(RedisConstants.LOGIN_CODE_KEY + phone);
        String code = loginForm.getCode();//这是通过登录信息json中得到用户填的验证码
        if (cachecode == null || !cachecode.toString().equals(code)){
            //4如果不一致报错
            return Result.fail("验证码错误");
        }

        //5如果一致，根据手机号查询用户 select * from tb_user where phone = ?
        User user = query().eq("phone", phone).one();//使用到了Mybits-plus
        //6判断用户是否存在
        if (user == null){
            //不存在创建新用户，保存到数据库中（用到了MBP）
            user = creatUserWithPhone(phone);//一个新的自创方法，创建新用户，并存放到数据库中
        }

        //7将用户信息保存到session当中、新方法保存在Redis中
//        session.setAttribute("user", BeanUtil.copyProperties(user, UserDTO.class));

        //用户信息保存在Redis中，键为Token，值为Map（内部有多个键值对）
        String userToken = UUID.randomUUID().toString(true);
        String userTokenKey = RedisConstants.LOGIN_USER_KEY + userToken;
        //需要先将对象转为MAP集合,注意放入Redis之前要进行字符串序列化
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);//将数据的粒度降级，UserDTO更加简洁
        Map<String, Object> map = BeanUtil.beanToMap(
                userDTO,
                new HashMap<>(),
                CopyOptions.create().ignoreNullValue()
                        .setFieldValueEditor((fileName, fileValue) -> fileValue.toString())//将所有属性变为String类型
        );
        //保存进Redis
        stringRedisTemplate.opsForHash().putAll(userTokenKey, map);

        //设置Redis有效期
        stringRedisTemplate.expire(userTokenKey, RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
        //将token返回给前端，相当于cookie中的sessionID

        return Result.ok(userToken);
    }

    /**
     * 根据id查询当前用户信息
     * @param userId
     * @return
     */
//    @Override
//    public Result queryUserById(Long userId) {
//
//        return null;
//    }

    private User creatUserWithPhone(String phone) {
        //1创建用户
        User user = new User();
        user.setPhone(phone);
        user.setNickName(USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
        //2保存用户到数据库中
        save(user);
        return user;
    }
}

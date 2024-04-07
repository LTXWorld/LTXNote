package com.hmdp.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: LoginInterceptor
 * Package:com.hmdp.utils
 * Description:
 *拦截器，实现接口
 * @author LTX
 * @version 炼气期
 * @Create 2024/4/5 20:06
 */
public class LoginInterceptor implements HandlerInterceptor {

//    private StringRedisTemplate stringRedisTemplate;
//
//    public LoginInterceptor(StringRedisTemplate stringRedisTemplate) {
//        this.stringRedisTemplate = stringRedisTemplate;
//    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //1获取Session\token
////        HttpSession session = request.getSession();
//        String token = request.getHeader("authorization");
//        //2获取session中的用户\获取redis中的用户
////        Object user = session.getAttribute("user");
//        //token不存在就拦截
//        if (StrUtil.isBlank(token)) {
//            response.setStatus(401);
//            return false;
//        }
//        String key = RedisConstants.LOGIN_USER_KEY + token;
//        Map<Object, Object> userMap = stringRedisTemplate.opsForHash().entries(key);
//        //3判断用户是否存在
//        if (userMap == null){
//            //4不存在拦截
//            response.setStatus(401);
//            return false;
//        }
//        //将查询到的Hash数据转为UserDTO对象
//        UserDTO user DTO = BeanUtil.fillBeanWithMap(userMap, new UserDTO(), false);
//        //5存在，保存用户信息到ThreadLocal并放行
//        UserHolder.saveUser(userDTO);
//
//        //刷新Token的有效期
//        stringRedisTemplate.expire(key, RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);

        //判断是否要拦截，从线程中取出用户,其他逻辑全部交给刷新拦截器
        if (UserHolder.getUser() == null) {
            response.setStatus(401);
            //拦截
            return false;
        }
        return true;
    }

//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        //业务完成后，移除用户
//        UserHolder.removeUser();
//    }
}

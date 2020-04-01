package me.zhengjie.utils;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {
    public static Object getLoginUser(RedisUtils redisUtils, HttpServletRequest request)
    {
       // JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
        String token = request.getHeader("Authorization") ;
        return redisUtils.get(token);
    }
}

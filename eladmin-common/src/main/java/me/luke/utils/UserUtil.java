package me.luke.utils;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {
    /**
     * 查询表配置
     * @param redisUtils 从调用类中传入
     * @param request 从controller中传中
     * @return 返回JwtUser 登录的完整信息缓存 /
     */
    public static Object getLoginUser(RedisUtils redisUtils, HttpServletRequest request)
    {
       // JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
        String token = request.getHeader("Authorization") ;
        return redisUtils.get(token);
    }
}

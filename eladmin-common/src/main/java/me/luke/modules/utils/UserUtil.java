package me.luke.modules.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    //随时随地获取当前的request
    public static HttpServletRequest getCurrentRequest(){

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
//                                                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        return request;
    }
    //随时随地获取当前的response
    public static HttpServletResponse getCurrentResponse(){
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletResponse response = ((ServletRequestAttributes)requestAttributes).getResponse();
        return response;
    }


}

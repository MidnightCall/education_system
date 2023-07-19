package com.edu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description 访问权限拦截器
 * @Author Lucas Wang
 * @Date 2023/7/13 20:07
 * @Version
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 拦截方法
     * @param request
     * @param response
     * @param handler
     * @return 拦截结果
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 如果本地没有用户，则代表无访问权限，拦截请求
        if(UserHolder.getUser() == null){
            response.setStatus(401);
            return true;
        }
        return true;
    }

}

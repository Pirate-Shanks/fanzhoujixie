package com.baogong.config;

import com.baogong.Utils.IsAllowedUtils;
import com.baogong.pojo.User;
import com.baogong.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private IsAllowedUtils isAllowedUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            if(!isAllowedUtils.isAllowedLogin()){
                return false;
            }
        return true;
    }
}

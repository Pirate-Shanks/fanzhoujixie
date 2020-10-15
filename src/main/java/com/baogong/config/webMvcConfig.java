package com.baogong.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webMvcConfig implements WebMvcConfigurer {
    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
   @Autowired
    private ManagerInterceptor managerInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
     //   registry.addInterceptor(managerInterceptor).addPathPatterns("/managerPass").addPathPatterns("/managerNotPass").addPathPatterns("/managerPassList").addPathPatterns("/managerNotPassList");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/public.html");
    }

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/public").setViewName("/public.html");
    }
}

package com.cdtu.yz.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，拦截以/**为前缀的url路径
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login.html").excludePathPatterns("/").excludePathPatterns("/index/**")
                .excludePathPatterns("/static/**").excludePathPatterns("/main").excludePathPatterns("").excludePathPatterns("/user/login");
    }

//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
//    }
}

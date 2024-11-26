package com.bbs;

import com.bbs.commom.CommonConfiguration;
import com.bbs.commom.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Import({
        CommonConfiguration.class
})
public class WebConfiguration implements WebMvcConfigurer {
    public void addInterceptor(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/login-code","logout")
                .excludePathPatterns("/image/**")
                .excludePathPatterns("/camera/detail","/order/upload","order/upload/v1")
                ;
    }
}
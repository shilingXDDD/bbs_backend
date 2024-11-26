package com.bbs.commom;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//跨域，支持来自不同域的客户端与服务端交互
@Configuration
@ComponentScan({"com.bbs.commom.web", "com.bbs.commom.service"})
@MapperScan("com.bbs.commom.mapper")
public class CommonConfiguration implements WebMvcConfigurer {
    @Value("${file.image.path}")
    private String imagePath;
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*");
        config.setAllowCredentials(true);
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.addExposedHeader("*");
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(corsConfigurationSource);
    }
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor pageInterceptor = new PaginationInnerInterceptor();
        pageInterceptor.setOverflow(false);
        pageInterceptor.setMaxLimit(20L);
        pageInterceptor.setDbType(DbType.MYSQL);
        interceptor.addInnerInterceptor(pageInterceptor);
        return interceptor;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/image/**").addResourceLocations("file:" + imagePath);
    }
}

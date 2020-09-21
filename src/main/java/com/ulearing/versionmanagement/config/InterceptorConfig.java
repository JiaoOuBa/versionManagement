package com.ulearing.versionmanagement.config;

import com.ulearing.versionmanagement.config.interceptor.CORSInterceptor;
import com.ulearing.versionmanagement.config.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * all请求拦截器配置
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 15:19
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public CORSInterceptor corsInterceptor() {
        return new CORSInterceptor();
    }

    @Bean
    public TokenInterceptor adminTokenInterceptor() {
        return new TokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor())
                // 拦截所有请求
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**").order(1);

        registry.addInterceptor(adminTokenInterceptor())
                // 拦截所有admin请求
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/error", "/swagger-ui.html/**").order(2);

    }
}

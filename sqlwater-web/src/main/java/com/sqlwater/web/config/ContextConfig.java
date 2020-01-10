package com.sqlwater.web.config;

import com.sqlwater.web.interceptor.AllScopeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Date 2019/12/3 20:59
 * @Version 1.0
 */
@Configuration
public class ContextConfig extends WebMvcConfigurationSupport {
    @Autowired
    AllScopeInterceptor allScopeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(allScopeInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/","classpath:/templates/");
        super.addResourceHandlers(registry);
    }

}

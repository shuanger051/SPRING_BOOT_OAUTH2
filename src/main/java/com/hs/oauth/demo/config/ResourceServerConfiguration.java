package com.hs.oauth.demo.config;

import com.hs.oauth.demo.config.handler.CustomAccessDeniedHandler;
import com.hs.oauth.demo.config.interceptor.MyFilterSecurityInterceptor;
import com.hs.oauth.demo.config.point.AuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * 配置资源自定义拦截器
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    /**
     * 用于配置对受保护的资源的访问规则
     * 默认情况下所有不在/oauth/**下的资源都是受保护的资源
     * @link OAuth2WebSecurityExpressionHandler
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(myFilterSecurityInterceptor,FilterSecurityInterceptor.class);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resourceServerSecurityConfigurer) throws Exception{
        resourceServerSecurityConfigurer.authenticationEntryPoint(new AuthExceptionEntryPoint()).accessDeniedHandler(new CustomAccessDeniedHandler());
    }

}

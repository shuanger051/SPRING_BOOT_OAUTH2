package com.hs.oauth.demo.config;

import com.hs.oauth.demo.service.CCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableAuthorizationServer
public class CustomOAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /**
     * @info TokenStore 默认有三种实现方式
     * 1.InMemoryTokenStore Token存储在内存中
     * 2.JdbcTokenStore  Token存储在数据库中
     * 3.JwtTokenStore 采用JWT认证机制
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        //使用数据库中的TOKEN
        return new JdbcTokenStore(dataSource);
    }

    @Bean
    public ClientDetailsService clientDetails(){
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * @info 注入认证管理类
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * @info 注入UserDetailsService 的自定义实现服务
     *       用于校验客户信息并以此颁发TOKEN字串
     */
    @Autowired
    private CCustomerService myUserDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    /**
     * @info 注入用户自定义异常翻译器，用来自定义异常信息输出
     */
    @Autowired
    private WebResponseExceptionTranslator customerWebResponseExceptionTranslator;

    /**
     * @info 服务认证配置授权类型 授权主要由 AuthorizationEndpoint 负责。
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore());
        endpoints.userDetailsService(myUserDetailsService);
        endpoints.setClientDetailsService(clientDetails());
        //配置TokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); // 1 天
        tokenServices.setRefreshTokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(1));// 30 天
        endpoints.tokenServices(tokenServices);
        endpoints.exceptionTranslator(customerWebResponseExceptionTranslator);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception{
        security.tokenKeyAccess("permitAll()");
        security.checkTokenAccess("isAuthenticated()");
        security.allowFormAuthenticationForClients();
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore());
        return tokenServices;
    }

}

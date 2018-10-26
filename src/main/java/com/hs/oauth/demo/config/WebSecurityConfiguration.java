package com.hs.oauth.demo.config;

import com.hs.oauth.demo.service.CCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration  extends GlobalAuthenticationConfigurerAdapter {

    private final CCustomerService userService;

    @Autowired
    public WebSecurityConfiguration(CCustomerService userService) {
        this.userService = userService;
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }




}

package com.hs.oauth.demo.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;
import java.util.Set;

public class CustomUserDetails extends User {

    private CCustomer user;

    public CustomUserDetails(CCustomer user) {
        super(user.getUserName(), user.getPassword(), true, true, true, true, Collections.EMPTY_SET);
        this.user = user;
    }

    public CustomUserDetails(CCustomer user, Set<GrantedAuthority> grantedAuthoritySet) {
        super(user.getUserName(), user.getPassword(), true, true, true, true,grantedAuthoritySet);
        this.user = user;
    }

    public CCustomer getUser() {
        return user;
    }

    public void setUser(CCustomer user) {
        this.user = user;
    }

}

package com.hs.oauth.demo.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

public class CustomerOauthException extends OAuth2Exception {

    public CustomerOauthException(String msg) {
        super(msg);
    }

}

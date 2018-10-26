package com.hs.oauth.demo.config.point;

import com.hs.oauth.demo.constants.SystemErrorConstants;
import com.hs.oauth.demo.exception.BizException;
import com.hs.oauth.demo.exception.builder.ErrorBuilder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @info 自定义TOKEN 异常信息
 * @date 2018-10-19
 */
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,AuthenticationException authException) throws RuntimeException {
        Throwable cause = authException.getCause();
        if(cause instanceof InvalidTokenException) {
            throw new BizException(ErrorBuilder.buildBizError(SystemErrorConstants.SYSTEM_HTTP_STATUS_ERROR_401, SystemErrorConstants.OAUTH_TOKEN_NO_ALLOW,"无效的Token"));
        }else{
            throw new BizException(ErrorBuilder.buildBizError(SystemErrorConstants.SYSTEM_HTTP_STATUS_ERROR_401,SystemErrorConstants.OAUTH_TOKEN_NO_ALLOW,"请传入认证信息"));
        }
    }

}

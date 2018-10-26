package com.hs.oauth.demo.config.handler;

import com.alibaba.fastjson.JSON;
import com.hs.oauth.demo.base.ResponseModel;
import com.hs.oauth.demo.constants.SystemErrorConstants;
import com.hs.oauth.demo.exception.bean.ExceptionErrorInfoEntity;
import com.hs.oauth.demo.exception.builder.ErrorBuilder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("customAccessDeniedHandler")
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * @info 权限不足时修改异常提示，原异常信息为：Access is denied
     * @param request
     * @param response
     * @param accessDeniedException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ExceptionErrorInfoEntity errorInfoEntity = ErrorBuilder.buildBizError(HttpServletResponse.SC_UNAUTHORIZED, SystemErrorConstants.OAUTH_TOKEN_GET_ERROR, "权限不足，拒绝访问");
        String jsonString = JSON.toJSONString(new ResponseModel(errorInfoEntity));
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(jsonString);
    }

}

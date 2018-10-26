package com.hs.oauth.demo.config.translator;

import com.hs.oauth.demo.base.ResponseModel;
import com.hs.oauth.demo.constants.SystemErrorConstants;
import com.hs.oauth.demo.exception.bean.ExceptionErrorInfoEntity;
import com.hs.oauth.demo.exception.builder.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @info 自定义异常翻译器
 * @date 2018-10-19
 */
@Component("customerWebResponseExceptionTranslator")
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {

    private static final Logger logger = LoggerFactory.getLogger(CustomWebResponseExceptionTranslator.class);

    /**
     * 抛出异常,跳出OAuth原有异常逻辑
     * @param ex
     * @return
     * @throws Exception
     */
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception ex) throws Exception {
        if(ex instanceof OAuth2Exception) {
            OAuth2Exception oAuth2Exception = (OAuth2Exception) ex;
            logger.error("OAuth认证异常： STATUS_CODE = " + oAuth2Exception.getHttpErrorCode() + " | ERROR_MESSAGE = " + oAuth2Exception.getMessage());
            Integer statusCode = (Integer) oAuth2Exception.getHttpErrorCode();
            ExceptionErrorInfoEntity errorInfoEntity = ErrorBuilder.buildBizError(statusCode, SystemErrorConstants.OAUTH_TOKEN_GET_ERROR, "无效认证");
            return new ResponseEntity(new ResponseModel(errorInfoEntity), HttpStatus.valueOf(statusCode));
        }else{
            logger.error("获取TOKEN异常：ERROR_MESSAGE = " + ex.getMessage());
            ExceptionErrorInfoEntity errorInfoEntity = ErrorBuilder.buildBizError(SystemErrorConstants.SYSTEM_HTTP_STATUS_ERROR_500, SystemErrorConstants.OAUTH_TOKEN_GET_ERROR_OTHER, "无效认证");
            return new ResponseEntity(new ResponseModel(errorInfoEntity), HttpStatus.valueOf(SystemErrorConstants.SYSTEM_HTTP_STATUS_ERROR_500));
        }
    }

}

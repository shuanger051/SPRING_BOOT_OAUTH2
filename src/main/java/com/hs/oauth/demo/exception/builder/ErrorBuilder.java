package com.hs.oauth.demo.exception.builder;

import com.hs.oauth.demo.exception.bean.ExceptionErrorInfoEntity;
import com.hs.oauth.demo.exception.properties.ExceptionProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 定义异常信息封装类
 */
@Component
@EnableConfigurationProperties(ExceptionProperties.class)
public final class ErrorBuilder {

    private static ExceptionProperties properties;
    /**
     * 构建错误信息
     * @param message       错误信息
     * @return          {@link ExceptionErrorInfoEntity}
     */
    public static ExceptionErrorInfoEntity buildBizError(String message){
        return buildBizError(HttpStatus.OK.value(),properties.getDefaultErrorCode(),message);
    }

    /**
     * 构建错误信息
     * @param code          错误码
     * @param message       错误信息
     * @return      {@link ExceptionErrorInfoEntity}
     */
    public static ExceptionErrorInfoEntity buildBizError (String code, String message){
        return buildBizError(HttpStatus.OK.value(),code,message);
    }

    /**
     * 基础信息构造器1
     * @param status        状态码
     * @param code          错误码
     * @param message       错误信息
     * @return {@link ExceptionErrorInfoEntity}
     */
    public static ExceptionErrorInfoEntity buildBizError(Integer status, String code, String message) {
        if(StringUtils.isBlank(code)){
            code = properties.getDefaultErrorCode();
        }
        if(status == null){
            status = properties.getDefaultStatus();
        }
        return new ExceptionErrorInfoEntity(status,code,message);
    }


    /**
     * 构建错误信息
     * @param message       错误信息
     * @return          {@link ExceptionErrorInfoEntity}
     */
    public static ExceptionErrorInfoEntity buildBindError(String message){
        return buildBindError(HttpStatus.BAD_REQUEST.value(),properties.getDefaultErrorCode(),message);
    }


    /**
     * 基础构造器2
     * @param status    状态码
     * @param code      错误码
     * @param message   错误信息
     * @return {@link ExceptionErrorInfoEntity}
     */
    public static ExceptionErrorInfoEntity buildBindError(Integer status, String code, String message) {
        if(status == null){
            status = HttpStatus.BAD_REQUEST.value();
        }
        return build(status,properties.getBindExceptionPrefix() + code,message);
    }
    /**
     * 构建错误信息
     * @param message       错误信息
     * @return          {@link ExceptionErrorInfoEntity}
     */
    public static ExceptionErrorInfoEntity buildSystemError(String message){
        return buildSystemError(properties.getDefaultStatus(),properties.getDefaultErrorCode(),message);
    }

    /**
     * 基础构造器2
     * @param status    状态码
     * @param code      错误码
     * @param message   错误信息
     * @return {@link ExceptionErrorInfoEntity}
     */
    public static ExceptionErrorInfoEntity buildSystemError(Integer status, String code, String message) {
        if(status == null){
            status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
        return build(status,properties.getSystemExceptionPrefix() + code,message);
    }


    /**
     * 完整构造器
     * @param status            状态码
     * @param code              错误码
     * @param message           错误信息
     * @return {@link ExceptionErrorInfoEntity}
     */
    public static ExceptionErrorInfoEntity build(Integer status, String code, String message) {
        if(StringUtils.isBlank(code)){
            code = properties.getDefaultErrorCode();
        }
        if(status == null){
            status = properties.getDefaultStatus();
        }
        return new ExceptionErrorInfoEntity(status,code,message);

    }

    @Autowired
    public  void setProperties(ExceptionProperties properties) {
        ErrorBuilder.properties = properties;
    }

}

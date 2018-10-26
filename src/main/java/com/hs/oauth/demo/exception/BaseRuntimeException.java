package com.hs.oauth.demo.exception;

import com.hs.oauth.demo.exception.bean.ExceptionErrorInfoEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

/**
 * 重写运行时异常
 */
public class BaseRuntimeException  extends RuntimeException{

    /**
     * 错误信息类
     */
    private ExceptionErrorInfoEntity error;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public BaseRuntimeException(ExceptionErrorInfoEntity error) {
        this.error = error;
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public BaseRuntimeException() {
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        if(ObjectUtils.nullSafeEquals(null,error)){
            return super.getMessage();
        }else{
            return StringUtils.isNotBlank(error.getMessage()) ? error.getMessage():super.getMessage();
        }
    }

    public ExceptionErrorInfoEntity getError() {
        return error;
    }

    /**
     * 设置异常类
     * @param error
     * @return
     */
    public BaseRuntimeException setError(ExceptionErrorInfoEntity error) {
        this.error = error;
        return this;
    }

}

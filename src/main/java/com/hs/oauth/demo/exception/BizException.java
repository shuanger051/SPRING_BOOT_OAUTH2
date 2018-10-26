package com.hs.oauth.demo.exception;

import com.hs.oauth.demo.exception.bean.ExceptionErrorInfoEntity;

/**
 * 定义业务统一异常处理器
 */
public class BizException extends BaseRuntimeException{

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param error
     */
    public BizException(ExceptionErrorInfoEntity error) {
        super(error);
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public BizException() {
    }

}

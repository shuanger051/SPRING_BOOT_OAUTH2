package com.hs.oauth.demo.exception;

import com.hs.oauth.demo.exception.bean.ExceptionErrorInfoEntity;

public class SystemException extends BaseRuntimeException {

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param error
     */
    public SystemException(ExceptionErrorInfoEntity error) {
        super(error);
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public SystemException() {
    }

}

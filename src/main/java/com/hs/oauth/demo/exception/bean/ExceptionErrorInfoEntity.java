package com.hs.oauth.demo.exception.bean;

public class ExceptionErrorInfoEntity {

    /**
     * 错误状态
     */
    private Integer status;

    /**
     * 错误吗
     */
    private String code;

    /**
     * 提示信息
     */
    private String message;


    /**
     * 基础信息构造器1
     * @param status        状态码
     * @param code          错误码
     * @param message       错误信息
     */
    public ExceptionErrorInfoEntity(Integer status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

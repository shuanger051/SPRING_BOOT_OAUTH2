package com.hs.oauth.demo.base;

public class ResponseModel<T> {

    /**
     * 标志是否成功
     */
    private Boolean success;

    /**
     * 数据
     */
    private T data;

    public ResponseModel() {
    }

    public ResponseModel(T data) {
        this.success = Boolean.TRUE;
        this.data = data;
    }
    public ResponseModel(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

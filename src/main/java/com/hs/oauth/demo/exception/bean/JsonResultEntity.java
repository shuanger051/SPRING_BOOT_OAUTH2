package com.hs.oauth.demo.exception.bean;

/**
 * 异常返回信息统一格式处理
 */
public class JsonResultEntity {

    /**
     * 标示请求结果为成功
     */
    private Boolean success = Boolean.TRUE;

    /**
     * controller 方法返回数据对象
     */
    private Object data;

    public JsonResultEntity(Object data) {
        this.data = data;
    }

    public JsonResultEntity(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}

package com.hs.oauth.demo.constants;

public interface SystemErrorConstants {

    String SYSTEM_PAGE_ERROR = "error";

    /**
     * 服务器错误HTTP状态码
     */
    int SYSTEM_HTTP_STATUS_ERROR_500 = 500;

    /**
     * 服务器错误HTTP状态码
     */
    int SYSTEM_HTTP_STATUS_ERROR_403 = 403;

    /**
     * 服务器错误HTTP状态码
     */
    int SYSTEM_HTTP_STATUS_ERROR_401 = 401;

    /**
     * 服务器错误HTTP状态码
     */
    int SYSTEM_HTTP_STATUS_ERROR_400 = 400;

    //============= SYSTEM ============
    String SYSTEM_SERVER_DEFAULT_ERROR = "100001";



    //============= OAUTH =============
    /**
     * TOKEN 校验失败 401
     */
    String  OAUTH_TOKEN_NO_CHECK_IN = "200001";

    /**
     * TOKEN 授权失败 400
     */
    String OAUTH_TOKEN_NO_ALLOW = "200002";

    /**
     * 获取TOKEN授权失败 500
     */
    String OAUTH_TOKEN_GET_ERROR = "200003";

    /**
     * 获取TOKEN授权失败_其他 500
     */
    String OAUTH_TOKEN_GET_ERROR_OTHER = "200004";


}

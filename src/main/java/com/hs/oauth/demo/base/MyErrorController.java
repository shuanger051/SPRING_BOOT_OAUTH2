package com.hs.oauth.demo.base;

import com.hs.oauth.demo.constants.SystemErrorConstants;
import com.hs.oauth.demo.exception.bean.ExceptionErrorInfoEntity;
import com.hs.oauth.demo.exception.builder.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 重写Spring框架ErrorController
 */
@Controller
public class MyErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(MyErrorController.class);

    @RequestMapping("/error")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) throws Exception{
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("exception");
        String errorMsg = request.getAttribute("javax.servlet.error.exception")== null? "系统错误" : ((Exception) request.getAttribute("javax.servlet.error.exception")).getMessage();
        if(null == statusCode ){
            statusCode = 500;
        }
        if(null != exception){
            errorMsg = exception.getMessage();
        }

        ExceptionErrorInfoEntity errorInfoEntity = ErrorBuilder.buildBizError(statusCode, SystemErrorConstants.SYSTEM_SERVER_DEFAULT_ERROR,errorMsg);

        return new ResponseEntity(errorInfoEntity, HttpStatus.valueOf(statusCode));

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}

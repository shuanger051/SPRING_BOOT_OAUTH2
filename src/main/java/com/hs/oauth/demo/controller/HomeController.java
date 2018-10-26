package com.hs.oauth.demo.controller;

import com.hs.oauth.demo.base.ResponseModel;
import com.hs.oauth.demo.exception.BizException;
import com.hs.oauth.demo.exception.builder.ErrorBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/index")
    public ResponseModel index(){
        return new ResponseModel("Hello INDEX!");
    }

    @RequestMapping("/fail")
    public ResponseModel fail(){
        return new ResponseModel("Hello ERROR!");
    }

    @RequestMapping("/login")
    public ResponseModel login(){
        return new ResponseModel("Hello LOGIN!");
    }

    @RequestMapping("/temp")
    public ResponseModel tempTest(){
        return new ResponseModel("Hello TEST!");
    }

}

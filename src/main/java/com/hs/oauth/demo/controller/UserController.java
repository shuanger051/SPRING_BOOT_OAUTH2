package com.hs.oauth.demo.controller;

import com.hs.oauth.demo.bean.SUser;
import com.hs.oauth.demo.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SUserService userService;

    @RequestMapping("/queryUserList")
    public List<SUser> queryUserList(){
        SUser user = new SUser();
        return userService.queryUserList(user);
    }


}

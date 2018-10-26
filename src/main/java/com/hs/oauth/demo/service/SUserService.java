package com.hs.oauth.demo.service;

import com.hs.oauth.demo.bean.SUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface SUserService {

    /**
     * 分页查询管理员信息
     * @param user
     * @return
     */
    public List<SUser> queryUserList(SUser user);

    /**
     * 根据ID获取管理员信息
     * @param user
     * @return
     */
    public SUser findUserByUserId(SUser user);


}

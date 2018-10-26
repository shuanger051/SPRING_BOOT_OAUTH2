package com.hs.oauth.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.hs.oauth.demo.bean.CustomUserDetails;
import com.hs.oauth.demo.bean.SRole;
import com.hs.oauth.demo.bean.SUser;
import com.hs.oauth.demo.mapper.SUserDAO;
import com.hs.oauth.demo.service.SRoleService;
import com.hs.oauth.demo.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SUserServiceImpl implements SUserService {

    @Autowired
    private SUserDAO userDao;

    @Autowired
    private SRoleService roleService;

    @Override
    public List<SUser> queryUserList(SUser bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        return userDao.queryUserList(bean);
    }

    @Override
    public SUser findUserByUserId(SUser user){
        return userDao.findUserByUserId(user);
    }


}

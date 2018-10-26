package com.hs.oauth.demo.service.impl;

import com.hs.oauth.demo.bean.CRole;
import com.hs.oauth.demo.mapper.CRoleDAO;
import com.hs.oauth.demo.service.CRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRoleServiceImpl implements CRoleService {

    @Autowired
    private CRoleDAO cRoleDAO;

    public List<CRole> getRoleByUserId(int userId){
        return cRoleDAO.getRoleByUserId(userId);
    }

}

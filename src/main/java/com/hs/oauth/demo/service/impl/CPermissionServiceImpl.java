package com.hs.oauth.demo.service.impl;

import com.hs.oauth.demo.bean.CPermission;
import com.hs.oauth.demo.mapper.CPermissionDAO;
import com.hs.oauth.demo.service.CPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPermissionServiceImpl implements CPermissionService{

    @Autowired
    private CPermissionDAO cPermissionDAO;

    /**
     * @info 根据角色ID获取权限信息
     * @param roleId
     * @return
     */
    public List<CPermission> getPermissionsByRoleId(int roleId){
        return cPermissionDAO.getPermissionsByRoleId(roleId);
    }

    /**
     * 查询所有权限信息
     * @return
     */
    public List<CPermission> queryAllPermission(){
        return cPermissionDAO.queryAllPermission();
    }

}

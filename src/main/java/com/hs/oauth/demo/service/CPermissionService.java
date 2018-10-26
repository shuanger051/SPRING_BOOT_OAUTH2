package com.hs.oauth.demo.service;

import com.hs.oauth.demo.bean.CPermission;

import java.util.List;

public interface CPermissionService {

    /**
     * 根据角色ID查询权限信息
     * @param roleId
     * @return
     */
    List<CPermission> getPermissionsByRoleId(int roleId);

    /**
     * 查询所有权限信息
     * @return
     */
    List<CPermission> queryAllPermission();

}

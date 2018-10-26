package com.hs.oauth.demo.mapper;

import com.hs.oauth.demo.bean.CPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CPermissionDAO {

    /**
     * 根据角色ID获取权限信息
     * @param roleId
     * @return
     */
    List<CPermission> getPermissionsByRoleId(@Param("roleId") Integer roleId);

    /**
     * @info 查询所有的权限列表
     * @return
     */
    List<CPermission> queryAllPermission();

}

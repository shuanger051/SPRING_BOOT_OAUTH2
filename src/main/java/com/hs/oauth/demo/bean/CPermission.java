package com.hs.oauth.demo.bean;

import com.hs.oauth.demo.base.BaseEntity;

import java.io.Serializable;
import java.sql.Date;

public class CPermission extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6490384197214681619L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限路径
     */
    private String permissionUrl;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @Override
    public String toString() {
        return "CPermission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", permissionUrl='" + permissionUrl + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }

}

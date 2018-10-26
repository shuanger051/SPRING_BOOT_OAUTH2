package com.hs.oauth.demo.bean;

import com.hs.oauth.demo.base.BaseEntity;

import java.io.Serializable;
import java.sql.Date;

public class SRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2972347558260243871L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色值
     */
    private String value;

    /**
     * 备注
     */
    private String tips;

    /**
     * 状态
     */
    private String status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", tips='" + tips + '\'' +
                ", status='" + status + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }

}

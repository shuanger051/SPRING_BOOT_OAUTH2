package com.hs.oauth.demo.bean;

import com.hs.oauth.demo.base.BaseEntity;

import java.io.Serializable;
import java.sql.Date;

public class CCustomer extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -6555167015680808301L;

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户渠道
     */
    private String userOrgId;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserOrgId() {
        return userOrgId;
    }

    public void setUserOrgId(String userOrgId) {
        this.userOrgId = userOrgId;
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
        return "CCustomer{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userOrgId='" + userOrgId + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }

}

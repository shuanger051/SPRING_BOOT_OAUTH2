package com.hs.oauth.demo.service;

import com.hs.oauth.demo.bean.CRole;

import java.util.List;

public interface CRoleService {

    public List<CRole> getRoleByUserId(int userId);

}

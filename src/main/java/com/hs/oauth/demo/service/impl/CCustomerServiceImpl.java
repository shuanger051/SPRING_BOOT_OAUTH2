package com.hs.oauth.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.hs.oauth.demo.bean.CCustomer;
import com.hs.oauth.demo.bean.CPermission;
import com.hs.oauth.demo.bean.CRole;
import com.hs.oauth.demo.bean.CustomUserDetails;
import com.hs.oauth.demo.mapper.CCustomerDAO;
import com.hs.oauth.demo.service.CCustomerService;
import com.hs.oauth.demo.service.CPermissionService;
import com.hs.oauth.demo.service.CRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 客户信息SERVICE
 */
@Service
public class CCustomerServiceImpl implements CCustomerService {

    @Autowired
    private CCustomerDAO cCustomerDAO;

    @Autowired
    private CRoleService cRoleService;

    @Autowired
    private CPermissionService cPermissionService;

    @Override
    public List<CCustomer> queryCustomerList(CCustomer bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        return cCustomerDAO.queryCustomerList(bean);
    }

    @Override
    public CCustomer findCustomerByUserId(CCustomer user){
        return cCustomerDAO.findCustomerByUserId(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CCustomer customer =  cCustomerDAO.loadCustomerByUserName(username);

        if (customer == null) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        List<CRole> roleList = cRoleService.getRoleByUserId(customer.getId());

        for (CRole role:roleList){
            //角色必须是ROLE_开头，可以在数据库中设置
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
            grantedAuthorities.add(grantedAuthority);
            //获取权限
            List<CPermission> permissionList = cPermissionService.getPermissionsByRoleId(role.getId());
            for (CPermission permission : permissionList) {
                GrantedAuthority authority = new SimpleGrantedAuthority(permission.getPermissionUrl());
                grantedAuthorities.add(authority);
            }
        }

        return new CustomUserDetails(customer,grantedAuthorities);

    }

}

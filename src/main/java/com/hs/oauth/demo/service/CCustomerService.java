package com.hs.oauth.demo.service;

import com.hs.oauth.demo.bean.CCustomer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CCustomerService extends UserDetailsService {

    /**
     * 分页查询用户信息
     * @param cCustomer
     * @return
     */
    public List<CCustomer> queryCustomerList(CCustomer cCustomer);

    /**
     * 根据ID获取用户信息
     * @param cCustomer
     * @return
     */
    public CCustomer findCustomerByUserId(CCustomer cCustomer);



}

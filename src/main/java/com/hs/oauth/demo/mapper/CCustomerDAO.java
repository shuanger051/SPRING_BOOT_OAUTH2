package com.hs.oauth.demo.mapper;

import com.hs.oauth.demo.bean.CCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CCustomerDAO {

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


    /**
     * 根据用户账号获取用户信息
     * @param userName
     * @return
     */
    CCustomer loadCustomerByUserName(@Param(value = "userName") String userName);

}

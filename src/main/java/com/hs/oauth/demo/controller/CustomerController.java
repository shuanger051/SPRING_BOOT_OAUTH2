package com.hs.oauth.demo.controller;

import com.hs.oauth.demo.base.ResponseModel;
import com.hs.oauth.demo.bean.CCustomer;
import com.hs.oauth.demo.service.CCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CCustomerService cCustomerService;

    /**
     * 查询客户信息
     * @return
     */
    @RequestMapping("/queryCustomerList")
    public ResponseModel<List<CCustomer>> queryUserList() {
        CCustomer customer = new CCustomer();
        List<CCustomer> list = cCustomerService.queryCustomerList(customer);
        return new ResponseModel(list);
    }

}

package com.hs.oauth.demo.mapper;

import com.hs.oauth.demo.bean.SUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SUserDAO {

    List<SUser> queryUserList(SUser user);

    SUser findUserByUserId(SUser user);

}

package com.hs.oauth.demo.mapper;

import com.hs.oauth.demo.bean.SRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SRoleDAO {

    SRole getRoleValuesByUserId(int userId);

}

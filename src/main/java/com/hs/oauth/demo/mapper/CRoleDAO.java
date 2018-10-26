package com.hs.oauth.demo.mapper;

import com.hs.oauth.demo.bean.CRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CRoleDAO {

    List<CRole> getRoleByUserId(@Param("userId")Integer userId);

}

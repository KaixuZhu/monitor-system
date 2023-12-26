package com.zr.auth.mapper;

import com.zr.auth.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("SELECT role.id, role.role_name, role.role_desc " +
            "FROM role, user_role " +
            "WHERE role.id=user_role.rid AND user_role.uid=#{uid}")
    List<Role> findByUid(Integer uid);
}

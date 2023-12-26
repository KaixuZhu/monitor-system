package com.zr.auth.mapper;

import com.zr.auth.entity.User;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface UserMapper {
	@Select("select * from user where username = #{username}")
	@Results({
			@Result(id = true, property = "id", column = "id"),
			@Result(property = "roles", column = "id", javaType = List.class,
					many = @Many(select = "com.zr.auth.mapper.RoleMapper.findByUid"))
	})
	User findByName(String username);
}

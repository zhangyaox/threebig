package com.zhangyaoxing.mapper;

import org.apache.ibatis.annotations.Param;

import com.zhangyaoxing.entity.User;

public interface UserMapper {
	
	User loging(@Param("username")String username,@Param("pwd")String pwd);
	
	int register(User user);//注册

	User getById(Integer uid);
}

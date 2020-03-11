package com.zhangyaoxing.service;

import com.zhangyaoxing.entity.User;

public interface UserService {
	
	User loging(String username,String pwd);
	
	User register(User user);//注册
	
	
}

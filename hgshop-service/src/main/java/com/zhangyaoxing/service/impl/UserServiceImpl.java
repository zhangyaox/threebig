package com.zhangyaoxing.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.zhangyaoxing.service.UserService;
@Service(interfaceClass = UserService.class,version = "1.0.0")
public class UserServiceImpl implements UserService {

	public boolean login(String name, String pass) {
		// TODO Auto-generated method stub
		return "admin".equals(name)&&"123456".equals(pass);
	}

}

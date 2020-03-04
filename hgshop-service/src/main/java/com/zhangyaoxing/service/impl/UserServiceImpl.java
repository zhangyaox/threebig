package com.zhangyaoxing.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhangyaoxing.config.Properties;
import com.zhangyaoxing.service.UserService;
@Service(interfaceClass = UserService.class,version = "1.0.0")
public class UserServiceImpl implements UserService {

	@Autowired
	Properties adminpro;
	
	public boolean login(String name, String pass) {
		// TODO Auto-generated method stub
		return "admin".equals(adminpro.getName())&&"123456".equals(adminpro.getPass());
	}

}

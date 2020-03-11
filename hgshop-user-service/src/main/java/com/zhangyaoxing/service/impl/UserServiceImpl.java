package com.zhangyaoxing.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhangyaoxing.entity.User;
import com.zhangyaoxing.mapper.UserMapper;
import com.zhangyaoxing.service.UserService;
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public User loging(String username, String pwd) {
		// TODO Auto-generated method stub
		//加密  DigestUtils.md5Hex(pwd)
		
		return userMapper.loging(username, DigestUtils.md5Hex(pwd));
	}

	@Override
	public User register(User user) {
		// 明文转换成密文
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		//添加成功or失败
		if(userMapper.register(user)>0) {
			//根据
			return userMapper.getById(user.getUid());
		}
		return null;
	}

}

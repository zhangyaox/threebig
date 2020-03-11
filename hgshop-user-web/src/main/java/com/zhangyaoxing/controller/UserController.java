package com.zhangyaoxing.controller;

import javax.servlet.http.HttpSession;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhangyaoxing.entity.User;
import com.zhangyaoxing.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Reference
	UserService userService;
	
	@RequestMapping("tologin")
	public String tologin() {
		
		return "user/login";
	}
	
	@RequestMapping("login")
	public String login(String username,String pwd,HttpSession session) {
		User login = userService.loging(username, pwd);
		if(login==null) {//登录失败
			return "user/login";
		}
		//成功session
		session.setAttribute("user", login);
		return "redirect:loginok";
	}
	
	@RequestMapping("loginok")
	public String loginok() {//登录成功
		
		return "home";
	}
	
	@RequestMapping("toregister")//去注册
	public String toregister() {
		
		return "user/register";
	}
	
	@RequestMapping("register")
	public String register(User user) {
		User login = userService.register(user);
		if(login==null) {//注册失败
			return "user/register";
		}
		return "redirect:tologin";
	}
}

package com.zhangyaoxing.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhangyaoxing.service.UserService;

@Controller
public class UserController {
	
	@Reference(timeout = 2000,version = "1.0.0")
	UserService userService;
	
	@RequestMapping("tologin")
	public String tologin() {
		return "login";
	}
	
	@RequestMapping("login")
	public String login(String name,String pass) {
		System.out.println("xm"+name+"pass"+pass);
		boolean login = userService.login(name, pass);
		System.err.println(login);
		if(userService.login(name, pass)) {
			System.err.println("xm"+name+"pass"+pass);
			return "redirect:/";
		}else {
			return "login";
		}
	}
}

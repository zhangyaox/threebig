package com.zhangyaoxing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Cart;
import com.zhangyaoxing.entity.Order;
import com.zhangyaoxing.entity.SpuEsVo;
import com.zhangyaoxing.entity.User;
import com.zhangyaoxing.service.CartService;
import com.zhangyaoxing.service.OrderService;
import com.zhangyaoxing.service.UserService;
import com.zhangyaoxing.util.ElSearchUtil;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Reference
	UserService userService;
	@Reference
	CartService cartService;
	@Reference
	OrderService orderService;
	@Autowired
	ElSearchUtil<SpuEsVo> elSearchUtils;
	
	
	@RequestMapping("tologin")
	public String tologin() {
		
		return "user/login";
	}
	
	@RequestMapping("login")
	public String login(String username,String pwd,HttpServletRequest request) {
		User login = userService.loging(username, pwd);
		if(login==null) {//登录失败
			return "user/login";
		}
		//成功session
		request.getSession().setAttribute("user", login);
		return "redirect:/user/loginok";
	}
	
	@RequestMapping("loginok")
	public String loginok() {//登录成功
		
		return "user/index";
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
	
	@ResponseBody
	@RequestMapping("addcart")//加入购物车
	public String addcart(int skuid,int buynum,HttpServletRequest request) {
		User attribute = (User) request.getSession().getAttribute("user");
		if(attribute==null) {
			return "没有登录。不能加入购物车哦";
		}
		int addCart = cartService.addCart(attribute.getUid(), skuid, buynum);
		return "1";
	}
	
	@RequestMapping("cartlist")//进入购物车
	public String cartlist(HttpServletRequest request,
			@RequestParam(defaultValue="1") int page) {
		//获取当前登录的用户
		User loginUser = (User)request.getSession().getAttribute("user");
		if(loginUser==null) {
			request.setAttribute("error", "您尚未登陆");
			return "error";
		}
		PageInfo<Cart> list = cartService.list(loginUser.getUid(), page);
		request.setAttribute("pageInfo", list);
		return "user/cartlist";
		
	}
	
	@RequestMapping("orderlist")//订单
	public String orderlist(HttpServletRequest request,Model m,
			@RequestParam(defaultValue="1") int page) {
		//获取当前登录的用户
		User loginUser = (User)request.getSession().getAttribute("user");
		if(loginUser==null) {
			request.setAttribute("error", "您尚未登陆");
			return "error";
		}
		PageInfo<Order> list = orderService.list(loginUser.getUid(), page);
		m.addAttribute("info", list);
		return "user/orderlist";
		
	}
	
	@RequestMapping("addorder")//下订单
	@ResponseBody
	public String addorder(HttpServletRequest request,
			@RequestParam("cartIds[]") int[] cartIds,String address){
		//获取当前登录的用户
		User loginUser = (User)request.getSession().getAttribute("user");
		if(loginUser==null) {
			request.setAttribute("error", "您尚未登陆");
			return "error";
		}
		System.out.println("cartIds is " + cartIds);
		int result = cartService.createOrdeer(loginUser.getUid(), address, cartIds);
		return result>0?"success":"添加失败";
	}
	
}

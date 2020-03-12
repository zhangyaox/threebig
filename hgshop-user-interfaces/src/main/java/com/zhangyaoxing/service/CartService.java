package com.zhangyaoxing.service;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Cart;

public interface CartService {
	int addCart(Integer uid,int skuid,int buynum);
	
	int delCart(int[] uid);
	
	int clearCart(int uid);//清空购物车
	
	PageInfo<Cart> list(int uid,int page);
	
	
	int createOrdeer(int uid, String address,int[] cartids);
}

package com.zhangyaoxing.mapper;

import java.util.List;

import com.zhangyaoxing.entity.Cart;

public interface CartMapper {
	
	int addCart(Integer uid,int skuid,int buynum);
	
	int delCart(int[] uid);
	
	int clearCart(int uid);//清空购物车
	
	List<Cart> list(int uid);
	
	List<Cart> listByIds(int[] cartIds);

	int add(Cart cart);
}

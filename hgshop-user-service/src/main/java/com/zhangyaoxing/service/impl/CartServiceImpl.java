package com.zhangyaoxing.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Cart;
import com.zhangyaoxing.entity.Order;
import com.zhangyaoxing.entity.OrderDetail;
import com.zhangyaoxing.mapper.CartMapper;
import com.zhangyaoxing.mapper.OrderMapper;
import com.zhangyaoxing.service.CartService;
@Service(interfaceClass =CartService.class )
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartMapper cartMapper;
	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public int addCart(Integer uid, int skuid, int buynum) {
		Cart cart = new Cart();
		cart.setUid(uid);//那个用户
		cart.setSkuid(skuid);//购买的商品
		cart.setPnum(buynum);//购买的数量
		
		
		return cartMapper.add(cart);
	}

	@Override
	public int delCart(int[] uid) {
		// TODO Auto-generated method stub
		return cartMapper.delCart(uid);
	}

	@Override
	public int clearCart(int uid) {
		// TODO Auto-generated method stub
		return cartMapper.clearCart(uid);
	}

	@Override
	public PageInfo<Cart> list(int uid, int page) {
		Page<Object> startPage = PageHelper.startPage(page, 5);
		List<Cart> list = cartMapper.list(uid);
		for (Cart cart : list) {
			System.out.println("==========------------="+cart);
		}
		return new PageInfo<Cart>(cartMapper.list(uid));
	}

	@Override
	public int createOrdeer(int uid, String address, int[] cartids) {
		//根据购物车id 查找表数据
		List<Cart> list = cartMapper.listByIds(cartids);
		//根据购物车id查找商品信息
		BigDecimal sumTotal = new BigDecimal(0);
		int addNum = 0;
		//计算总价格
		for (Cart cart : list) {
			sumTotal=sumTotal.add(cart.getSumtotal());
		}
		System.out.println("=================================="+sumTotal);
		//生成主表的数据
				Order order = new Order();
				//用户
				order.setUid(uid);
				order.setSumtotal(sumTotal);//计算总价格
				order.setAddress(address);//邮寄地址
				
				addNum += orderMapper.add(order);
				
				//生成子表的数据
				for (Cart cart : list) {
					OrderDetail orderDetail = new OrderDetail(order.getOid(),cart);
					//插入子表
					addNum += orderMapper.addDetail(orderDetail);
				}
				
				//从购物车中删除这些数据
				cartMapper.delCart(cartids);
		return addNum;
	}

}

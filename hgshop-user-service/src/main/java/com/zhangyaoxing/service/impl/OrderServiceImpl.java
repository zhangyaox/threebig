package com.zhangyaoxing.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Order;
import com.zhangyaoxing.entity.OrderDetail;
import com.zhangyaoxing.mapper.OrderMapper;
import com.zhangyaoxing.service.OrderService;
@Service(interfaceClass =OrderService.class )
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public PageInfo<Order> list(int userid, int page) {
		PageHelper.startPage(page, 5);
		return new PageInfo<Order>(orderMapper.list(userid));
	}

	@Override
	public List<OrderDetail> listDetail(int orderid, int page) {
		
		return orderMapper.listDetail(orderid);
	}

}

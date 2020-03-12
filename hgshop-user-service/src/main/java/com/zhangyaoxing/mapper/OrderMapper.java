package com.zhangyaoxing.mapper;

import java.util.List;

import com.zhangyaoxing.entity.Order;
import com.zhangyaoxing.entity.OrderDetail;

public interface OrderMapper {
	
	List<Order> list(int userid);
	
	List<OrderDetail> listDetail(int orderid);
	
	int addDetail(OrderDetail orderDetail);

	int add(Order order);
}

package com.zhangyaoxing.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Order;
import com.zhangyaoxing.entity.OrderDetail;

public interface OrderService {
	PageInfo<Order> list(int userid,int page);
	
	List<OrderDetail> listDetail(int orderid,int page);
}

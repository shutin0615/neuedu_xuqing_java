package com.neuedu.service;

import java.util.List;

import com.neuedu.data.DataSource;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;

public interface OrderService {

	boolean creatOrder();
	
	//生成订单号order_no
	
	long generateOrderNo();
	//查看订单
	public List<UserOrder> findOrder();
	//查看订单明细
	public List<UserOrderItem> findOrderItem();

}
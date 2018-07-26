package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrder;

public interface OrderDao {

	//创建订单
	boolean creatOrder(UserOrder userOrder);
    
	//获取订单Id
	int generateOrderId();
	
	//查看订单
	List<UserOrder> findOrder();
}

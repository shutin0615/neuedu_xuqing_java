package com.neuedu.service;

import java.util.List;

import com.neuedu.data.DataSource;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;

public interface OrderService {

	boolean creatOrder();
	
	//���ɶ�����order_no
	
	long generateOrderNo();
	//�鿴����
	public List<UserOrder> findOrder();
	//�鿴������ϸ
	public List<UserOrderItem> findOrderItem();

}
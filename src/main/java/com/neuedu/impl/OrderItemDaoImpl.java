package com.neuedu.impl;

import java.util.List;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.data.DataSource;
import com.neuedu.entity.UserOrderItem;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public boolean addOrderItems(List<UserOrderItem> orderItems) {
		// TODO Auto-generated method stub
		return  DataSource.orderItems.addAll(orderItems);
		
	}

	@Override
	public int generateOrderItemId() {
		// TODO Auto-generated method stub
		return DataSource.orderItems.size()+1;
	}

	@Override
	public List<UserOrderItem> findOrderItem() {
		
		return DataSource.orderItems;
	}

}

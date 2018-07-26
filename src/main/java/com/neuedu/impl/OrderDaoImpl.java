package com.neuedu.impl;

import java.util.List;

import com.neuedu.dao.OrderDao;
import com.neuedu.data.DataSource;
import com.neuedu.entity.UserOrder;

public class OrderDaoImpl implements OrderDao{

	@Override
	public boolean creatOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
	return	DataSource.orders.add(userOrder);
		
	}

	@Override
	public int generateOrderId() {
		// TODO Auto-generated method stub
		return DataSource.orders.size()+1;
	}

	@Override
	public List<UserOrder> findOrder() {
		
		return DataSource.orders;
	}

}

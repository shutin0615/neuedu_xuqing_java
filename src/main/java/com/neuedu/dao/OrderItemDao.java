package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrderItem;

public interface OrderItemDao {
    //�������µĶ�����ϸ��ӵ�������ϸ������
	 boolean addOrderItems(List<UserOrderItem> orderItems);
     
	 //���ɶ�����ϸid
     int generateOrderItemId();
     
     List<UserOrderItem> findOrderItem();
}

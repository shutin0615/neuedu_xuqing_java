package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrder;

public interface OrderDao {

	//��������
	boolean creatOrder(UserOrder userOrder);
    
	//��ȡ����Id
	int generateOrderId();
	
	//�鿴����
	List<UserOrder> findOrder();
}

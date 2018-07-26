package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart;

public interface CartService {

	//���ﳵ�����Ʒ
		boolean addCart(Cart cart);
	 	 
		//ɾ��
		boolean deleteCart(int id);
		
		//�޸�
		boolean updateCart(Cart cart);
		
		//��ѯ
		List<Cart>findAllCart();
		
		//��ȡ���ﳵ����Ʒ����
		int getCatrNum();
		
		Cart getCartById(int id);
		
		//�޸Ĺ��ﳵ��Ʒ��Ϣ
		boolean updateCart(int id, int num);
}

package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;

public interface CartDao {
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
	
	//�޸Ĺ��ﳵ��Ʒ��Ϣ
	boolean updateCart(int id, int num);

	Cart getCartById(int id);
	
	//��չ��ﳵ
	void claerCart(); 
}

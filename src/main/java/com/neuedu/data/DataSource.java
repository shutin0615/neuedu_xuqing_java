package com.neuedu.data;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.entity.Account;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;

public class DataSource {
 
	//�û�
	public static List<Account> accs=new ArrayList<Account>();
	
	//������Ʒ����
	public static List<Product> products=new ArrayList<Product>();
    
	//���幺�ﳵ����
	public static List<Cart> carts=new ArrayList<Cart>();
	
	//�ҵĶ�������
	public static List<UserOrder> orders=new ArrayList<UserOrder>();
    
	//������ϸ����
	public static List<UserOrderItem> orderItems=new ArrayList<UserOrderItem>();
	
	
	
	public DataSource() {
		Account acc = new Account(1,"admin","admin");
		accs.add(acc);
	}
}
  
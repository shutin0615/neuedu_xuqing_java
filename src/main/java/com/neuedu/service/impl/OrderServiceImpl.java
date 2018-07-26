package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.impl.CartDaoImpl1;
import com.neuedu .impl.OrderDaoImpl1;
import com.neuedu.impl.OrderItemDaoImpl1;
import com.neuedu.impl.ProductDaoImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.utils.utils;

public class OrderServiceImpl implements OrderService {
   //CartDao cartDao=new CartDaoImpl();
	CartDao cartDao=new CartDaoImpl1();
  // OrderDao orderDao=new OrderDaoImpl();
   OrderDao orderDao=new OrderDaoImpl1();
   OrderItemDao orderItemDao=new  OrderItemDaoImpl1();
   ProductDao pr=new ProductDaoImpl();
	public boolean creatOrder() {
		// TODO Auto-generated method stub
		//1.��ȡ���ﳵ�еĹ�����ϢList<Cart>
		List<Cart>carts=cartDao.findAllCart();
		if(carts==null||carts.size()<=0){
			return false;
		}
		
		//2.����һ������ʵ����UserOrder
		UserOrder userOrder=createUserOrder() ;
		
		//3.��������Ϣ����ת�ɶ�����ϸ����List<UserOrderItem>
		List<UserOrderItem> orderItems=new ArrayList<UserOrderItem>();
		for(int i=0;i<carts.size();i++) {
			Cart cart=carts.get(i);
			UserOrderItem orderItem=utils.convertToOrderItem(orderItemDao.generateOrderItemId(), userOrder.getOrder_no(), cart);
			//4.������
			if(orderItem.getQuantity()<=cart.getProduct().getStock()) {
				//������
				orderItems.add(orderItem);
			}else {
				//��治��
				return false;
			}
		}
		
		//5.���㶩���۸�
		userOrder.setPayment(getOrderPrice(orderItems));
		
		//6.�µ�
		orderDao.creatOrder(userOrder);
		orderItemDao.addOrderItems(orderItems);
		
		//7.�۳����
		for(int i=0;i<carts.size();i++){
			Cart cart=carts.get(i);
			Product product=cart.getProduct();
			int leftStock=(int) (product.getStock()-cart.getProductnum());
			product.setStock(leftStock);
			pr.deletestock(product);
		}
		//8.��չ��ﳵ
		cartDao.claerCart();
		return true;
	}
	//�������ɶ�������
	 public UserOrder createUserOrder() {
		UserOrder order=new UserOrder();
		//����һ������id
		order.setId(orderDao.generateOrderId());
		//1s=1000ms(����) 1970.1.1�������� ��ʱ���
		order.setOrder_no(System.currentTimeMillis());
		//��������ʱ��
		order.setCreate_time(System.currentTimeMillis());
		return order;
	 }
	 
	//���ɶ�����
	@Override
	public long generateOrderNo() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis();
	}
	
	//���㶩���۸�
	public double getOrderPrice(List<UserOrderItem> items) {
		double totalPrice=0.0;
		for(int i=0;i<items.size();i++) {
			totalPrice+=items.get(i).getTotal_price();
		}
		return totalPrice;
	}
	@Override
	public List<UserOrder> findOrder() {
		
		return orderDao.findOrder();
	}
	@Override
	public List<UserOrderItem> findOrderItem() {
		
		return orderItemDao.findOrderItem();
	} 
	 
	 
}

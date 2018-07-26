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
		//1.获取购物车中的购物信息List<Cart>
		List<Cart>carts=cartDao.findAllCart();
		if(carts==null||carts.size()<=0){
			return false;
		}
		
		//2.生成一个订单实体类UserOrder
		UserOrder userOrder=createUserOrder() ;
		
		//3.将购物信息集合转成订单明细集合List<UserOrderItem>
		List<UserOrderItem> orderItems=new ArrayList<UserOrderItem>();
		for(int i=0;i<carts.size();i++) {
			Cart cart=carts.get(i);
			UserOrderItem orderItem=utils.convertToOrderItem(orderItemDao.generateOrderItemId(), userOrder.getOrder_no(), cart);
			//4.检验库存
			if(orderItem.getQuantity()<=cart.getProduct().getStock()) {
				//库存充足
				orderItems.add(orderItem);
			}else {
				//库存不足
				return false;
			}
		}
		
		//5.计算订单价格
		userOrder.setPayment(getOrderPrice(orderItems));
		
		//6.下单
		orderDao.creatOrder(userOrder);
		orderItemDao.addOrderItems(orderItems);
		
		//7.扣除库存
		for(int i=0;i<carts.size();i++){
			Cart cart=carts.get(i);
			Product product=cart.getProduct();
			int leftStock=(int) (product.getStock()-cart.getProductnum());
			product.setStock(leftStock);
			pr.deletestock(product);
		}
		//8.清空购物车
		cartDao.claerCart();
		return true;
	}
	//用来生成订单对象
	 public UserOrder createUserOrder() {
		UserOrder order=new UserOrder();
		//设置一个订单id
		order.setId(orderDao.generateOrderId());
		//1s=1000ms(毫秒) 1970.1.1——现在 的时间差
		order.setOrder_no(System.currentTimeMillis());
		//创建订单时间
		order.setCreate_time(System.currentTimeMillis());
		return order;
	 }
	 
	//生成订单号
	@Override
	public long generateOrderNo() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis();
	}
	
	//计算订单价格
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

package com.neuedu.utils;

import java.util.Scanner;

import com.neuedu.entity.Cart;
import com.neuedu.entity.UserOrderItem;
//封装通用方法
public class utils {

	//封装接收键盘输入方法 
		public static String input(String msg){
			Scanner in=new Scanner(System.in);
			System.out.print(msg);
			 return in.nextLine();
			 //等价于	String name = input.nextLine();return result;
		
		}
		
		public static int inputInt(String msg){
			Scanner in= new Scanner(System.in);
			System.out.print(msg);
			int operation = in.nextInt();
			return operation;
		    }
		
		public static double inputDouble(String msg){
			Scanner in= new Scanner(System.in);
			System.out.print(msg);
			double  operation = in.nextDouble();
			return operation;
		    }
		
		//将购物车实体类转成订单明细实体类
		public static UserOrderItem convertToOrderItem(int id,long order_no,Cart cart){
			UserOrderItem orderItem=new UserOrderItem();
		    orderItem.setId(id);
		    orderItem.setOrder_no(order_no);
		    orderItem.setProduct_id(cart.getProduct().getId());
		    orderItem.setProduct_name(cart.getProduct().getName() );
		    orderItem.setProduct_image(cart.getProduct().getImage());
		    orderItem.setCurrent_unit_price(cart.getProduct().getPrice());
		    orderItem.setQuantity(cart.getProductnum());
		    orderItem.setTotal_price(cart.getProduct().getPrice()*cart.getProductnum());
		    orderItem.setCreate_time(System.currentTimeMillis());
		    
		    return orderItem;
		}
		
}






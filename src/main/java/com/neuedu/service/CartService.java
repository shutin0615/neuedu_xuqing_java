package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart;

public interface CartService {

	//购物车添加商品
		boolean addCart(Cart cart);
	 	 
		//删除
		boolean deleteCart(int id);
		
		//修改
		boolean updateCart(Cart cart);
		
		//查询
		List<Cart>findAllCart();
		
		//获取购物车中商品数量
		int getCatrNum();
		
		Cart getCartById(int id);
		
		//修改购物车商品信息
		boolean updateCart(int id, int num);
}

package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;

public interface CartDao {
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
	
	//修改购物车商品信息
	boolean updateCart(int id, int num);

	Cart getCartById(int id);
	
	//清空购物车
	void claerCart(); 
}

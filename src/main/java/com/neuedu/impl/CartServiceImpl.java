package com.neuedu.impl;

import java.util.List;

import com.neuedu.dao.CartDao;

import com.neuedu.impl.CartDaoImpl1;
import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;

public class CartServiceImpl implements CartService {
   // CartDao cartDao=new CartDaoImpl();
	CartDao cartDao=new CartDaoImpl1();
	public boolean addCart(Cart cart) {
		
		// TODO Auto-generated method stub
		return cartDao.addCart(cart);
	}

	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}

	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		return cartDao.findAllCart();
	}

	@Override
	public int getCatrNum() {
		// TODO Auto-generated method stub
		return cartDao.getCatrNum();
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cartDao.updateCart(id, num);
	}

	@Override
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		return cartDao.getCartById(id);
	}

}

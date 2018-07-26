package com.neuedu.impl;

import com.neuedu.dao.LoginDao;

import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.utils.MD5Utils;

public class LoginServiceImpl implements LoginService {

	//LoginDao ld = new LoginDaoImpl();
	LoginDao ld = new LoginDaoImpl1();

	public Account doLogin(String username, String password) {
		
		return ld.doLogin(username, password);
	}

	@Override
	public void addToken(String token,Account acc) {
		
		ld.addToken(token, acc);
		
		
	}

	@Override
	public String findTokenById(int id) {
		// TODO Auto-generated method stub
		return ld.findTokenById(id);
	}

}

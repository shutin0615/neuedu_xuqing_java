package com.neuedu.dao;

import com.neuedu.entity.Account;

public interface LoginDao {

	//(���ݿ�)

	public Account doLogin(String username, String password);
    //jsp
	//int checkUserName(String username);

	public void addToken(String token, Account acc);
	
	public String findTokenById(int id);
	
}

package com.neuedu.service;

import com.neuedu.entity.Account;

public interface LoginService {

	public Account doLogin(String username, String password);
	
	public void addToken(String token, Account acc);
	
	public String findTokenById(int id);
	
}

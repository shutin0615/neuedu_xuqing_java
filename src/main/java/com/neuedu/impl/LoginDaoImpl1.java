package com.neuedu.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.neuedu.dao.LoginDao;
import com.neuedu.entity.Account;
import com.neuedu.utils.DBUtils;

public class LoginDaoImpl1 implements LoginDao{
	public Account doLogin(String username, String password) {

		Account account=null;
		Connection conn=null;
		PreparedStatement st=null; 
		
		try {
			conn=DBUtils.getConnection();
			
			
			String  sql="select * from  account where username=? and password=? ";
			 st=conn.prepareStatement(sql);
			//给占位符赋值
			 st.setString(1, username);
			 st.setString(2, password);
			
			// asfksadfsdf'  or 1=1 -- ''
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			if(rs.first()) {
				 int  id= rs.getInt("id");	
				 String  username1=rs.getString("username");
				 String password1=rs.getString("password");
				 account=new Account(id,username1,password1);
			}
			return account;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	     return null;
	}

	@Override
	public void addToken(String token, Account acc) {
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update account set token=? where id=?";
			st=conn.prepareStatement(sql);
			
			st.setString(1,token);
			st.setInt(2, acc.getId());
			System.out.println(sql);
			st.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}

	@Override
	public String findTokenById(int id) {
		
		Connection conn=null;
		PreparedStatement st=null; 
		
		try {
			conn=DBUtils.getConnection();
			
			
			String  sql="select token from  account where id=? ";
			 st=conn.prepareStatement(sql);
			//给占位符赋值
			 st.setInt(1, id);
			
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			if(rs.first()) {
				
				 String  token=rs.getString("token");
				 return token;
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
		
	}



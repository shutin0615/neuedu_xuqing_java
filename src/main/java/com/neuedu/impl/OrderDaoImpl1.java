package com.neuedu.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.DBUtils;

public class OrderDaoImpl1 implements OrderDao{

	@Override
	public boolean creatOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub

		Connection conn=null;
		Statement st=null;
	
		try {
			
            conn=DBUtils.getConnection();
			st=conn.createStatement();
			
			String sql1="insert into userorder(order_no,user_id,shipping_id,payment,payment_type,postage,status,create_time)"
					  + " values("+userOrder.getOrder_no()+","+userOrder.getUser_id()+","+userOrder.getShipping_id()+","+userOrder.getPayment()+","+userOrder.getPayment_type()+","+userOrder.getPostage()+","+userOrder.getStatus()+",now())";
			st.execute(sql1);
			return true;
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
		return false;
	}

	@Override
	public int generateOrderId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserOrder> findOrder() {

		List<UserOrder> orders=new ArrayList<UserOrder>();
		Connection conn=null;
		Statement st =null;
		ResultSet rs=null;
		
		try {
			
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String sql="select * from userorder" ;
			rs=st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int user_id=rs.getInt("user_id");
				int shipping_id=rs.getInt("shipping_id");
				String  payment_type=rs.getString("payment_type");
				int postage=rs.getInt("postage");
				int status=rs.getInt("status");
				long order_no=rs.getLong("order_no");
				long create_time=rs.getLong("create_time");
				double payment=rs.getDouble("payment");
				
				UserOrder order=new UserOrder();
				
				order.setId(id);
				order.setUser_id(user_id);
				order.setShipping_id(shipping_id);
				order.setOrder_no(order_no);
				order.setPayment_type(payment_type);
				order.setPostage(postage);
				order.setStatus(status);
				order.setPayment(payment);
				order.setCreate_time(create_time);
				orders.add(order);
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				DBUtils.close(conn, st, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	return orders;	
	}

}

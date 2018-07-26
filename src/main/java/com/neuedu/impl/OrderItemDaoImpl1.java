package com.neuedu.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.DBUtils;

public class OrderItemDaoImpl1 implements OrderItemDao{

	@Override
	public boolean addOrderItems(List<UserOrderItem> orderItems) {
		Connection conn=null;
		Statement st=null;
	
		try {
		    conn=DBUtils.getConnection();
			st=conn.createStatement();
			
			String sql1="insert into userorderitem(order_no,user_id,product_id,product_name,product_image,current_unit_price,quantity,total_price,create_time) values";
			StringBuffer sbuffer=new StringBuffer(sql1);
			for(int i=0;i<orderItems.size();i++) {
				UserOrderItem userOrdeItem=orderItems.get(i);
				sbuffer.append("(");
				//sbuffer.append(userOrdeItem.getId()+",");
				sbuffer.append(userOrdeItem.getOrder_no()+",");
				sbuffer.append(userOrdeItem.getUser_id()+",");
				sbuffer.append(userOrdeItem.getProduct_id()+",");
				sbuffer.append("'"+userOrdeItem.getProduct_name()+"',");
				sbuffer.append("'"+userOrdeItem.getProduct_image()+"',");
				sbuffer.append(userOrdeItem.getCurrent_unit_price()+",");
				sbuffer.append(userOrdeItem.getQuantity()+",");
				sbuffer.append(userOrdeItem.getTotal_price()+",");
				sbuffer.append("now()");
				sbuffer.append(")");
				if(i!=orderItems.size()-1) {
					sbuffer.append(",");
				}
			}
			System.out.println(sbuffer.toString());
			    st.execute(sbuffer.toString());
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
	public List<UserOrderItem> findOrderItem(){
		// TODO Auto-generated method stub
		
				List<UserOrderItem> orderItems=new ArrayList<UserOrderItem>();
				Connection conn=null;
				Statement st =null;
				ResultSet rs=null;
				try {
					
					conn=DBUtils.getConnection();
					st=conn.createStatement();
					String sql="select * from userorderitem" ;
					rs=st.executeQuery(sql);
					
					while(rs.next()) {
					    int id = rs.getInt("id");
				        long order_no=rs.getLong("order_no");
				        int user_id=rs.getInt("user_id");
				        int product_id=rs.getInt("product_id");
						String  product_name=rs.getString("product_name");
						String  product_image=rs.getString("product_image");
						double current_unit_price=rs.getDouble("current_unit_price");
						int quantity=rs.getInt("quantity");
						double total_price=rs.getDouble("total_price");
						long create_time=rs.getLong("create_time");
						long update_time=rs.getLong("update_time");
						
						UserOrderItem userorderItem=new UserOrderItem();
						
						userorderItem.setId(id);
						userorderItem.setOrder_no(order_no);
						userorderItem.setUser_id(user_id);
						userorderItem.setProduct_id(product_id);
						userorderItem.setProduct_name(product_name);
						userorderItem.setProduct_image(product_image);
						userorderItem.setCurrent_unit_price(current_unit_price);
						userorderItem.setCreate_time(create_time);
						userorderItem.setUpdate_time(update_time);
						userorderItem.setQuantity(quantity);
						userorderItem.setTotal_price(total_price);
						
					
						orderItems.add(userorderItem);
					}
				}  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						DBUtils.close(conn,st,rs);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			return orderItems;
	}
	@Override
	public int generateOrderItemId() {
		// TODO Auto-generated method stub
		return 0;
	}

}

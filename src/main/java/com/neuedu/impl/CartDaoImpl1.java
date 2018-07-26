package com.neuedu.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;



public  class CartDaoImpl1 implements CartDao{
	ProductDao productDao=new  ProductDaoImpl();
	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
        Connection conn=null;
		PreparedStatement st=null;
	
		try {
			conn=DBUtils.getConnection();
			//int id=cart.getId();
			int pid=cart.getProduct().getId();
			long pnum=cart.getProductnum();
			
			String sql1="insert into cart(productid,productnum) values(?,?)";
			st=conn.prepareStatement(sql1);
			st.setInt(1, pid);
			st.setLong(2, pnum);
			
			st.execute();
			
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
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub

		Connection conn=null;
		PreparedStatement st=null;
	
		try {
			conn=DBUtils.getConnection();
			
			String sql2="delete from cart where id="+id+""; 				
			st=conn.prepareStatement(sql2);
			st.execute(sql2);
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
		
		return true;
	}

    @Override
	public List<Cart> findAllCart() {
		
    	List<Cart> carts=new ArrayList<Cart>();
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConnection();
			
			String sql="select * from cart" ;
			st=conn.prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()) {
				//id,productid,productnum
				int id=rs.getInt("id");
				int productid=rs.getInt("productid");
				int productnum=rs.getInt("productnum");
				
				Cart cart=new Cart();
				cart.setId(id);
				cart.setProductnum(productnum);
				
				List<Product> pro=findDetailById(productid);
				for(int i=0;i<pro.size();i++) {
					Product products=pro.get(i);
					cart.setId(id);
					cart.setProductnum(productnum);
					cart.setProduct(products);
				}
				carts.add(cart);
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
	return carts;
	}
    
  //商品
  	public List<Product> findDetailById(int product_id) {
  		
  		List<Product> pros=new ArrayList<Product>();
  		Connection conn=null;
  		PreparedStatement st=null;
  		ResultSet rs=null;
  		
  		try {
  			
  			conn=DBUtils.getConnection();
  			
  			String sql="select * from product where id="+product_id;
  			st=conn.prepareStatement(sql);
  			rs=st.executeQuery(sql);
  			
  			while(rs.next()) {
  				int id=rs.getInt("id");
  				String  name=rs.getString("name");
  				String pdesc=rs.getString("pdesc");
  				int price=rs.getInt("price");
  				String rule=rs.getString("rule");
  				String image=rs.getString("image");
  				int stock=rs.getInt("stock");
 
  				Product pro=new Product();
  				pro.setId(id);
  				pro.setName(name);
  				pro.setDesc(pdesc);
  				pro.setPrice(price);
  				pro.setRule(rule);
  				pro.setStock(stock);
  				pros.add(pro);
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
  	return pros;
  	}

    @Override
	public int getCatrNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub

		Connection conn=null;//
		PreparedStatement st=null;
		//实例化驱动类
		try {
			//获取连接
			conn=DBUtils.getConnection();
			//获取statement对象，执行sql语句
			
			
			String sql2="update  cart set productnum=? where id=?";	
			
			st=conn.prepareStatement(sql2);
			st.setInt(1, num);
			st.setInt(2, id);
			st.execute();		
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
	public void claerCart() {
		Connection coon = null;
		Statement st = null;
		try {
			coon = DBUtils.getConnection();
			st = coon.createStatement();
			
			String sql = "delete from cart";
			st.execute(sql);
		
		} catch (SQLException e) {
			try {
				DBUtils.close(coon, st);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

	//通过ID查找到这个购物车
		public Cart getCartById(int id) {
			
			Connection coon = null;
			Statement st = null;
			ResultSet rs = null;
			
			Cart cart = null;
			try {
				coon = DBUtils.getConnection();
				st = coon.createStatement();
				String sql = "select * from cart";
				rs = st.executeQuery(sql);
				while(rs.next()) {
					if(id==rs.getInt("id")) {
						cart = new Cart();
						int _id = rs.getInt("id");
						int num = rs.getInt("productnum");
						cart.setId(_id);
						cart.setProductnum(num);
						
					}
				}
				
				
			} catch (SQLException e) {
				try {
					DBUtils.close(coon, st, rs);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			
			
			
			
			return cart;
			
			
		}

	
	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

package com.neuedu.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;


public  class ProductDaoImpl implements ProductDao{

	public static void main(String[] args) {
		ProductDao product=new ProductDaoImpl();
		String json=JSONArray.toJSONString(product.findAll());
	    System.out.println(json);
	}
	
	public void find() {
		
		
	}
	
	
	
	@Override
	public boolean addProduct(Product product) {
		
		Connection conn=null;
		PreparedStatement st=null;
		
		String name=product.getName();
		String pdesc=product.getDesc();
		double  price=product.getPrice();
		String rule=product.getRule();
		String image=product.getImage();
		int  stock=product.getStock() ;
		
		try {
			System.out.println("驱动加载成功");
			//获取Connection连接
			conn=DBUtils.getConnection();
			//System.out.println("获取连接成功");
			
			//获取statement对象，执行sql语句
			String sql1="insert into product(name,pdesc,price,rule,image,stock) values(?,?,?,?,?,?)";
			st=conn.prepareStatement(sql1);
			st.setString(1,name);
			st.setString(2, pdesc);
			st.setDouble(3, price);
			st.setString(4, rule);
			st.setString(5, image);
			st.setInt(6, stock);
			
			st.execute();
			return true;
		}catch (SQLException e) {
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
			

	public List<Product> findAll() {
			List<Product>pds=new ArrayList<Product>();
			Connection conn=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			try {
				conn=DBUtils.getConnection();
			    String sql="select id,name,pdesc,price,rule,image,stock from product";
			    st=conn.prepareStatement(sql);
				rs=st.executeQuery();
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String pdesc=rs.getString("pdesc");
					int  price=rs.getInt("price");
					String rule=rs.getString("rule");
					String image=rs.getString("image");
					int stock=rs.getInt("stock");
					Product pd=new Product();
					pd.setId(id);
					pd.setDesc(pdesc);
					pd.setName(name);
					pd.setPrice(price);
					pd.setRule(rule);
					pd.setImage(image);
					pd.setStock(stock);
					pds.add(pd);
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
			return pds;
			//return DataSource.products;
	}

	@Override
	public boolean updateProduct(Product product) {
		Connection conn=null;
		PreparedStatement st=null;
		
		try {
			conn=DBUtils.getConnection();
		    int id=product.getId();
			String name=product.getName();
			String pdesc=product.getDesc();
			double price=product.getPrice();
			String rule=product.getRule();
			String image=product.getImage();
			int stock=product.getStock();
			String sql="update product set name=?,pdesc=?,price=?,rule=?,image=?,stock=? where id=?";
			st=conn.prepareStatement(sql);
			st.setString(1,name);
			st.setString(2,pdesc);
			st.setDouble(3,price);
			st.setString(4,rule);
			st.setString(5,image);
			st.setInt(6,stock);
			st.setInt(7,id);
			
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
		return true;
	}
	/*	// TODO Auto-generated method stub
		//先查询到要修改的商品（通过唯一标识查询）
		List<Product> products=DataSource.products;
		for(int i=0;i<products.size();i++) {
			Product p=products.get(i);
			int _id=p.getId();
			if(_id==product.getId()){
				//将新的商品赋给旧的商品
			products.set(i,product);
				return true;
			}
		}
		return false;*/
	

	@Override
	public boolean deleteProduct(int id) {
	Connection conn=null;
	PreparedStatement st=null;
	try {
		conn=DBUtils.getConnection();
		String sql="delete from product where id=?";
		st=conn.prepareStatement(sql);
		st.setInt(1,id);
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
	return true;
		/*// TODO Auto-generated method stub
		List<Product> products=DataSource.products;
		for(int i=0;i<products.size();i++) {
			Product p=products.get(i);
			//商品Id
			int _id=p.getId();
			if(_id==id){
				products.remove(i);
				return true;
			}
		}
		return false;*/
	}

	public List<Product> findDetailById(int id){
		List<Product> pros=new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
	    	String sql="select id,name,pdesc,price,rule,image from product where id=?";
			st=conn.prepareStatement(sql);
			st.setInt(1, id);
			rs=st.executeQuery();
			while(rs.next()) {
				int id1=rs.getInt("id");
				String name=rs.getString("name");
				String pdesc=rs.getString("pdesc");
				int  price=rs.getInt("price");
				String rule=rs.getString("rule");
				String image=rs.getString("image");
				Product pd=new Product();
				pd.setId(id1);
				pd.setDesc(pdesc);
				pd.setName(name);
				pd.setPrice(price);
				pd.setRule(rule);
				pd.setImage(image);
				pros.add(pd);
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
		//return DataSource.products;
   }


/*// TODO Auto-generated method stub
		List<Product> list=DataSource.products;
		for(int i=0;i<list.size();i++) {
			Product p=list.get(i);
			if(p.getId()==id) {
				return p;
			}
		}
		return null;*/
//通过ID查找
	public Product findProductById(int id) {
		
		Product product =null;
		Connection coon = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//temp1加载驱动
		try {
			
			System.out.println("加载驱动完成");
			//temp2获取连接
			coon=DBUtils.getConnection();
			//temp3获取statement
			String sql = "select * from product";
			st = coon.prepareStatement(sql);
		
			 rs = st.executeQuery();
			 System.out.println("sql语句执行完毕");
			 while(rs.next()) {
				if(id == rs.getInt("id")) {
					product=new Product();
					
					int _id = rs.getInt("id");
					product.setId(_id);
					product.setName(rs.getString("name"));
					product.setDesc(rs.getString("pdesc"));
					product.setPrice(rs.getDouble("price"));
					product.setRule(rs.getString("rule"));
					product.setImage(rs.getString("image"));
					product.setStock(rs.getInt("stock"));
				
				}
				
			 }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				DBUtils.close(coon, st, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	
		return product;
	}


	@Override
	public PageModel<Product> findEmpByPage(int pageNo, int pageSize) {
		
		PageModel<Product> pageModel=new PageModel<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConnection();
			
			//查询总的记录数
			String sqlcount="select count(id) from product";
			pst=conn.prepareStatement(sqlcount);
			rs=pst.executeQuery();
			if(rs.next()) {
				int totalCount=rs.getInt(1);//总的记录
				//计算共多少页
				int totalPage=(totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);	
				pageModel.setTotalPage(totalPage);
				
			}
			
			String sql="select id,name,pdesc,price,rule,image,stock from product limit ?,?";
			System.out.println(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1,(pageNo-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			
			List<Product> list=new ArrayList<Product>();
			while(rs.next()) {
				
				Product product=new Product(rs.getInt("id"),rs.getString("name"),rs.getString("pdesc"),rs.getDouble("price"),rs.getString("rule"),rs.getString("image"),rs.getInt("stock"));
			    list.add(product);
			
			}
			pageModel.setData(list);
			pageModel.setCurrentPage(pageNo);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn,pst,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return pageModel;
		}


	@Override
	public void deletestock(Product product) {
		Connection coon = null;
		PreparedStatement st = null;
		try {
			System.out.println("驱动加载完成");
			coon = DBUtils.getConnection();
			String sql ="update product set stock= ? where id=? ";
			st = coon.prepareStatement(sql);
			st.setInt(1, product.getStock());
			st.setInt(2, product.getId());
			
			st.execute();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(coon, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	}
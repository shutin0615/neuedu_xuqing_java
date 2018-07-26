package com.neuedu.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.neuedu.dao.CateGoryDao;
import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageModel;
import com.neuedu.utils.DBUtils;


public class CateGoryDaoImpl implements CateGoryDao {


	//添加
	public boolean addCategory(CateGory category) {
		//temp1 加载驱动
				Connection coon = null;
				PreparedStatement st = null;
				
			
				try {
					System.out.println("加载驱动完成");
					coon = DBUtils.getConnection();
					
					
					String sql ="insert into category(parent_id,name,status,sort_order,create_time,update_time)values(?,?,?,?,now(),now())";
					st = coon.prepareStatement(sql);
					st.setInt(1, category.getParent_id());
					st.setString(2, category.getName());
					st.setInt(3, category.getStatus());
					st.setInt(4, category.getSort_order());
					
							
					st.execute();
					System.out.println("Sql语句执行完毕！");
					return true;
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					try {
						DBUtils.close(coon, st);
					
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			//temp3获取statement 对象调用执行方法

			
		return false;
	}

	//查看类别
	public List<CateGory> findAll() {
		 List<CateGory> categorys = new ArrayList<CateGory>();
			Connection coon = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			//temp1加载驱动
			try {
				
				System.out.println("加载驱动完成");
				//temp2获取连接
				coon = DBUtils.getConnection();
				//temp3获取statement
				String sql = "select * from category";
				st = coon.prepareStatement(sql);
				
				 rs = st.executeQuery();
				 System.out.println("sql语句执行完毕");
				 while(rs.next()) {
					 	int   id = rs.getInt("id");
						int  parent_id = rs.getInt("parent_id");   
						String name = rs.getString("name");
						int status = rs.getInt("status"); 	//类别状态
						int sort_order = rs.getInt("sort_order");   //排序编号
						String create_time = rs.getString("create_time");
						String update_time = rs.getString("update_time");
					
						CateGory category = new CateGory(id,parent_id,name,status,sort_order,create_time,update_time);
						categorys.add(category);
						
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
		
			return categorys;
		
	}

	@Override
	public boolean updateCategory(CateGory category) {
		Connection coon = null;
		PreparedStatement st = null;
		try {
			coon = DBUtils.getConnection();
		
			
			String sql = "update category set parent_id=?,name=?,status=?,sort_order=?,create_time=now(),update_time=now()  where id=? ";
			st = coon.prepareStatement(sql);
			st.setInt(1,category.getParent_id() );
			st.setString(2, category.getName());
			st.setInt(3,category.getStatus() );
			st.setInt(4,category.getSort_order());
		
			st.setInt(5, category.getId());
			
			st.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(coon, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return false;
	}

	@Override
	public boolean deleteCategory(int id) {
		Connection coon = null;
		PreparedStatement st = null;
		try {
			System.out.println("驱动加载完成");
			coon = DBUtils.getConnection();
			
			
			String sql ="delete from category where id=? ";
			st = coon.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();
			return true;
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
		
		return false;
		
	}

	@Override
	public CateGory findCategoryById(int id) {
		CateGory category = new CateGory();
		Connection coon = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//temp1加载驱动
		try {
			
			System.out.println("加载驱动完成");
			//temp2获取连接
			coon = DBUtils.getConnection();
			//temp3获取statement
			String sql = "select * from category where id=?";
			st = coon.prepareStatement(sql);
			st.setInt(1, id);
			
			 rs = st.executeQuery();
			 System.out.println("sql语句执行完毕");
			 if(rs.first()) {
				
				 category.setId(rs.getInt("id"));
				 category.setParent_id((rs.getInt("id")));
				 category.setName(rs.getString("name"));
				 category.setStatus(rs.getInt("status"));
				 category.setSort_order(rs.getInt("sort_order"));
				 category.setCreate_time(rs.getString("create_time"));
				 category.setUpdate_time(rs.getString("update_time"));
				
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
	
		return category;
	}

	@Override
	public PageModel<CateGory> findCategoryByPage(int pageNo, int pageSize) {
		PageModel<CateGory> pageModel = new PageModel<CateGory>();
		
		Connection coon = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//temp1加载驱动
		try {
			coon = DBUtils.getConnection();
			String sqlcount = "select count(id) from category";
			st = coon.prepareStatement(sqlcount);
			rs = st.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);//总的数据记录数
				//计算有几页
				
				int totalPage = (count%pageSize)==0?count/pageSize:(count/pageSize+1);
				pageModel.setTotalPage(totalPage);
				//pageModel.setTotalpage(totalPage);
			}
			
			
			System.out.println("加载驱动完成");
			//temp2获取连接
			
			//temp3获取statement
			String sql = "select * from category limit ?,? ";
			
			st = coon.prepareStatement(sql);
			st.setInt(1, (pageNo-1)*pageSize);
			st.setInt(2, pageSize); 
			rs = st.executeQuery();
			List<CateGory> categorys = new ArrayList<CateGory>(); 
			 System.out.println("sql语句执行完毕");
			 while(rs.next()) {
				 	int   id = rs.getInt("id");
					int  parent_id = rs.getInt("parent_id");   
					String name = rs.getString("name");
					int status = rs.getInt("status"); 	//类别状态
					int sort_order = rs.getInt("sort_order");   //排序编号
					String create_time = rs.getString("create_time");
					String update_time = rs.getString("update_time");
				
					CateGory cate = new CateGory(id,parent_id,name,status,sort_order,create_time,update_time);
					categorys.add(cate);
				
			 }
			 pageModel.setData(categorys);
			 pageModel.setCurrentPage(pageNo);
			
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
	
		return pageModel;
	
		
	}

}

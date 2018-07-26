package com.neuedu.dao;



import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductDao {

	//添加
	boolean addProduct(Product product);
	
	//查看
	List<Product>findAll();
	
	//修改
	boolean updateProduct(Product product);
	
	//删除
	boolean deleteProduct(int id);
	
	//根据id查询商品
	public List<Product> findDetailById(int id);
		
	Product findProductById(int id);
	
	//分页获取数据。pageNo获取第几页，pageSize每页页多少条数据
	public PageModel<Product> findEmpByPage(int pageNo, int pageSize);
	
	//扣库存
	public void deletestock(Product product);
	
}

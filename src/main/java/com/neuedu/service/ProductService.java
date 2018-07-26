package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductService {

	//添加
	public boolean addProduct(Product product);
	
	//查看
	public List<Product>findAll();
	
	//修改
	public boolean updateProduct(Product product);
	
	//删除
	public boolean deleteProduct(int id);
	
	public List<Product> shouwProductDetailInfo(int id);
	
	Product findProductById(int id);
	
	//分页获取员工信息
	public PageModel<Product> findProductByPage(Integer pageNo, Integer pageSize);
	
	
}

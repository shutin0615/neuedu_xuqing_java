package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.impl.ProductDaoImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDao productDao=new ProductDaoImpl();
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(id);
	}

	@Override
	public List<Product> shouwProductDetailInfo(int id) {
		// TODO Auto-generated method stub
		return  productDao.findDetailById(id);
	}
    public Product findProductById(int id) {
		
		return productDao.findProductById(id);
	}

	@Override
	public PageModel<Product> findProductByPage(Integer pageNo, Integer pageSize) {
	
		
		
		return productDao.findEmpByPage(pageNo, pageSize);
	}

	
}

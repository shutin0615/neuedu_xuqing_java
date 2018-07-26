package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductService {

	//���
	public boolean addProduct(Product product);
	
	//�鿴
	public List<Product>findAll();
	
	//�޸�
	public boolean updateProduct(Product product);
	
	//ɾ��
	public boolean deleteProduct(int id);
	
	public List<Product> shouwProductDetailInfo(int id);
	
	Product findProductById(int id);
	
	//��ҳ��ȡԱ����Ϣ
	public PageModel<Product> findProductByPage(Integer pageNo, Integer pageSize);
	
	
}

package com.neuedu.dao;



import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductDao {

	//���
	boolean addProduct(Product product);
	
	//�鿴
	List<Product>findAll();
	
	//�޸�
	boolean updateProduct(Product product);
	
	//ɾ��
	boolean deleteProduct(int id);
	
	//����id��ѯ��Ʒ
	public List<Product> findDetailById(int id);
		
	Product findProductById(int id);
	
	//��ҳ��ȡ���ݡ�pageNo��ȡ�ڼ�ҳ��pageSizeÿҳҳ����������
	public PageModel<Product> findEmpByPage(int pageNo, int pageSize);
	
	//�ۿ��
	public void deletestock(Product product);
	
}

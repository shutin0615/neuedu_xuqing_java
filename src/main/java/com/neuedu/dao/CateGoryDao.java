package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageModel;


public interface CateGoryDao {

	        //���
			boolean addCategory(CateGory category);
			//�鿴
			List<CateGory> findAll();
			//�޸�
			boolean updateCategory(CateGory category);
			//ɾ��
			boolean deleteCategory(int id);
			//����ID�鿴ĳ�����
			CateGory findCategoryById(int id);
			//��ҳ��ȡ����
			PageModel<CateGory> findCategoryByPage(int pageNo, int pageSize);
	
	
}

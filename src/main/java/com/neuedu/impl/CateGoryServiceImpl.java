package com.neuedu.impl;

import java.util.List;

import com.neuedu.dao.CateGoryDao;

import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageModel;
import com.neuedu.service.CateGoryService;

public class CateGoryServiceImpl implements CateGoryService {

	CateGoryDao cgd = new CateGoryDaoImpl();

	public boolean addCategory(CateGory category) {
		// TODO Auto-generated method stub
		return cgd.addCategory(category);
	}

	public List<CateGory> findAll() {
		// TODO Auto-generated method stub
		return cgd.findAll();
	}

	public boolean updateCategory(CateGory category) {
		// TODO Auto-generated method stub
		return cgd.updateCategory(category);
	}

	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return cgd.deleteCategory(id);
	}


	public CateGory findCategoryById(int id) {
		// TODO Auto-generated method stub
		return cgd.findCategoryById(id);
	}

	
	public PageModel<CateGory> findCategoryByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return cgd.findCategoryByPage(pageNo, pageSize);
	}

	




	
}

package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageModel;


public interface CateGoryDao {

	        //添加
			boolean addCategory(CateGory category);
			//查看
			List<CateGory> findAll();
			//修改
			boolean updateCategory(CateGory category);
			//删除
			boolean deleteCategory(int id);
			//根据ID查看某个类别
			CateGory findCategoryById(int id);
			//分页获取数据
			PageModel<CateGory> findCategoryByPage(int pageNo, int pageSize);
	
	
}

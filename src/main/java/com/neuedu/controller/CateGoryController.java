package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageModel;
import com.neuedu.service.CateGoryService;
import com.neuedu.service.impl.CateGoryServiceImpl;





@WebServlet("/view/Category1")
public class CateGoryController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1631046995858860367L;
	 public CateGoryController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String operation = request.getParameter("opera");
				
			if(operation!=null&&!operation.equals("")) {
				if(operation.equals("1")) {
					addCategory(request,response);
					
				}else if(operation.equals("2")) {
					findAll(request,response);
					
				}else if(operation.equals("3")) {
					updateCategory(request,response);
					
				}else if(operation.equals("4")) {
					deleteCategory(request,response);
					
				}else if(operation.equals("5")) {
					showCategory(request,response);
				}
			}
		}

		
		

			//修改
	public boolean updateCategory(CateGory category) {
			return cgs.updateCategory(category);
			
		}
		
		private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("id"));
			int parent_id = Integer.parseInt(request.getParameter("parent_id"));
			
			String name = request.getParameter("name");
			int status = Integer.parseInt(request.getParameter("status"));
			int sort_order = Integer.parseInt(request.getParameter("sort_order"));
			
			CateGory category = cgs.findCategoryById(id);
			 category = new CateGory(id,parent_id,name,status,sort_order);
			boolean result = updateCategory(category);
			if(result) {
				System.out.println("修改类别成功");
				findAll(request,response);
			}else {
				System.out.println("修改类别失败");
			}
		}



			//根据ID查看某个类别
		public CateGory findCategoryById(int id) {
				return cgs.findCategoryById(id);
				
		}
		private void showCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			CateGory category =findCategoryById(id);
			
			request.setAttribute("category", category);
			request.getRequestDispatcher("updateCategory.jsp").forward(request, response);
			
		}



		//删除
			boolean deleteCategory(int id) {
				return cgs.deleteCategory(id);
				
			}
			private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = 0;
			double price = 0.0;
			boolean result = false;
			try {
				id = Integer.parseInt(request.getParameter("id"));
						
				result = deleteCategory(id);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			if(result) {
				System.out.println("删除商品成功");
				findAll(request, response);
				
			}else {
				System.out.println("删除商品失败");
			}
			
		}



		/*查看类别到jsp页面*/

		public void findAll(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
			String pageNo=request.getParameter("pageNo");
			System.out.println("===pageNo="+pageNo);
			String pageSize=request.getParameter("pageSize");
			
			int _pageNo=1;
			int _pageSize=3;
			
				if(pageNo!=null&&pageSize!=null) {
					
					_pageNo=Integer.parseInt(pageNo);
					_pageSize=Integer.parseInt(pageSize);
						 
				}
			CateGoryService category=new CateGoryServiceImpl();
			PageModel<CateGory> pageModel=category.findCategoryByPage(_pageNo, _pageSize);
			request.setAttribute("pageModel", pageModel);
			request.getRequestDispatcher("findc.jsp").forward(request, respose);
			
		}

		
		/*
		 * 添加类别
		 * */
			boolean addCategory(CateGory category){
				return cgs.addCategory(category);
				
			}
			private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				int parent_id = Integer.parseInt(request.getParameter("parent_id"));
				System.out.println(parent_id);
				String name = request.getParameter("name");
				int status = Integer.parseInt(request.getParameter("status"));
				int sort_order = Integer.parseInt(request.getParameter("sort_order"));
				
				
				CateGory category = new CateGory(parent_id,name,status,sort_order);
				boolean result = addCategory(category);
				if(result) {
					System.out.println("添加类别成功");
					findAll(request,response);
				}else {
					System.out.println("添加类别失败");
				}
			}
		



		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			doGet(request, response);
		}

//		CateGoryServiceImpl cgs = new CateGoryServiceImpl();
		CateGoryService cgs=new CateGoryServiceImpl();
		
	
	
	
	
	

}

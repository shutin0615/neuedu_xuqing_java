package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;


@WebServlet("/view/product")
public class ProductController extends HttpServlet{
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 8552255678912455988L;
	ProductService  pService=new ProductServiceImpl();
	
     @Override
 	protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
 		
    	 
    	 response.setContentType("text/html;charset=UTF-8");
    	 
 		String operation=requset.getParameter("operation");
 		
 		if(operation!=null&&!operation.equals("")) {
 			if(operation.equals("1")) {
 				addProduct(requset,response);
 				
 			}else if(operation.equals("2")) {
 				findAll(requset,response);
 				
 			}else if(operation.equals("3")) {
 				updateProduct(requset,response);
 				
 			}else if(operation.equals("4")) {
 				deleteProduct(requset,response);
 			
 			}else if(operation.equals("5")) {
 			   //��ѯ������Ʒ�޸�	
 				findProductById(requset,response);
 				
 			}else if(operation.equals("6")) {
  			   //��ѯ������Ʒչʾ	
 				showProduct(requset,response);
  				
  			}
 		}else {
 			
 		}
 	
 		
 	}
 	
	@Override
 	protected void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {

 		doGet(requset,response);
 		
 	}
 	//���
    public boolean addProduct(Product product){
 				return pService.addProduct(product);
 			}
 	public void addProduct(HttpServletRequest requset,HttpServletResponse response) throws ServletException, IOException {
 		Product product=new Product();
 		
 		String name=requset.getParameter("pname");
 		String desc=requset.getParameter("pdesc");
 		String image=requset.getParameter("pimage");
 		String rule=requset.getParameter("rule");
 		
 		int stock=0;
 		double price=0.0;
 		boolean result= false;
 		
 		try{
 		price=Double.parseDouble(requset.getParameter("price"));
 		stock=Integer.parseInt(requset.getParameter("stock"));
 		
 		product.setName(name);
 		product.setDesc(desc);
 		product.setPrice(price);
 		product.setImage(image);
 		product.setRule(rule);
 		product.setStock(stock);
 		
 		result=addProduct(product);
 		if(result) {
 			System.out.println("��Ʒ��ӳɹ�");
 		
			findAll(requset,response);
 		}else {
 			System.out.println("��Ʒ���ʧ��");
 		}
 		
 		}catch(NumberFormatException e) {
 			e.printStackTrace();
 		}
 	}
 	
 	//��ѯ
	protected void findAll(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		  
		String pageNo=requset.getParameter("pageNo");
		System.out.println("===pageNo="+pageNo);
		String pageSize=requset.getParameter("pageSize");
		
		int _pageNo=1;
		int _pageSize=3;
		
			if(pageNo!=null&&pageSize!=null) {
				
				_pageNo=Integer.parseInt(pageNo);
				_pageSize=Integer.parseInt(pageSize);
					 
			}
		
			PageModel<Product> pageModel=pService.findProductByPage(_pageNo,_pageSize);
			requset.setAttribute("pageModel", pageModel);
			requset.getRequestDispatcher("showproductpage.jsp").forward(requset, response);

		
 	}
	//�޸�
	public boolean updateProduct(Product product){
				return pService.updateProduct(product);
			}

	 public  void  updateProduct (HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		 	int id = 0;
		 	int stock=0;
			double price = 0.0;
			boolean result = false;
			try {
				
				id = Integer.parseInt(requset.getParameter("id"));
				
				String name = requset.getParameter("name");
				String desc = requset.getParameter("pdesc");
				price = Double.parseDouble(requset.getParameter("price"));
				String rule = requset.getParameter("rule");
				String image = requset.getParameter("image");
			    stock=Integer.parseInt(requset.getParameter("stock"));
				
				Product product = findProductById(id);
				product.setName(name);
				product.setDesc(desc);
				product.setPrice(price);
				product.setRule(rule);
				product.setImage(image);
				product.setStock(stock);
				
				result = updateProduct(product);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			if(result) {
				System.out.println("�޸���Ʒ�ɹ�");
				findAll(requset,response);
			}else {
				System.out.println("�޸���Ʒʧ��");
			}
			
		 
		 
	    }
	 
	 //ɾ��
	 public boolean deleteProduct(int id){
		 return pService.deleteProduct(id);
		}
	 
	 public  void deleteProduct (HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
	    	
		    int id = 0;
			double price = 0.0;
			boolean result = false;
			try {
				id = Integer.parseInt(requset.getParameter("id"));
						
				result = deleteProduct(id);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			if(result) {
				System.out.println("ɾ����Ʒ�ɹ�");
				//PageController _pc = new PageController();
				findAll(requset, response);
			}else {
				System.out.println("ɾ����Ʒʧ��");
			}
		 
		 
	    } 
	 
		
		
	//ͨ��ID
	 private void findProductById(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
			String sid=requset.getParameter("id");
			int id=0;
			try {
				id = Integer.parseInt(sid);
				Product product=findProductById(id);		
				if(product!=null) {
					//��ѯ�ɹ�
					
					requset.setAttribute("product",product);
					requset.getRequestDispatcher("update.jsp").forward(requset, response);;
				}else {
					
				}
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
		}
		public Product findProductById(int id) {
			
			
			
			return pService.findProductById(id);
		}
		/*չʾ������Ʒ*/
		private void showProduct(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Product product = findProductById(id);
				
			request.setAttribute("product", product);
			request.getRequestDispatcher("danproduct.jsp").forward(request, respose);
			
		}
		
		
		//��תҳ��
		public void jump(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
			ProductService ps = new ProductServiceImpl();
			PageModel<Product> pageModel = ps.findProductByPage(1, 3);
			request.setAttribute("pageModel", pageModel);
			request.getRequestDispatcher("showorder.jsp").forward(request, respose);
		}
		
		//����Id��ѯ��Ʒ��ϸ��Ϣ
		public List<Product> shouwProductDetailInfo(int id){
			return pService.shouwProductDetailInfo(id);
		}
	
}

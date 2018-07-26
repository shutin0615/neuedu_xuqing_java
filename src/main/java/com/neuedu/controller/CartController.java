package com.neuedu.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService;
import com.neuedu.service.impl.CartServiceImpl;

@WebServlet("/view/cart")
public class CartController extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String operation = request.getParameter("operation");
			if(operation.equals("1")) {
				addCart(request,response);
			}else if(operation.equals("2")) {
				findCart(request,response);
			}else if(operation.equals("3")) {
				deleteCart(request,response);
			}else if(operation.equals("4")) {
				updateCart(request,response);
			}else if(operation.equals("5")) {
				getCartById(request,response);
			}
		 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2712593772760736118L;
	CartService cartService=new CartServiceImpl();
	ProductController product=new ProductController();
	//���ﳵ�����Ʒ
			public boolean addCart(Cart cart) {
				return cartService.addCart(cart);
			}
			
			public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				Cart cart=new Cart();
				
				
				int id=0;
				int num=0;
				boolean result=false;
				
				try {
					id=Integer.parseInt(request.getParameter("id"));
					num=Integer.parseInt(request.getParameter("productnum"));
					Product pro=product.findProductById(id);
					cart.setProduct(pro);
					cart.setProductnum(num);
					
					result=addCart(cart);
	
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}
				if(result) {
					System.out.println("���빺�ﳵ�ɹ�");
					findCart(request,response);
				}else {
					System.out.println("���빺�ﳵʧ��");
				}
				
				
				
			}
			//��ѯ
			
			public void findCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				List<Cart> carts=cartService.findAllCart();
				request.setAttribute("carts", carts);
				request.getRequestDispatcher("showcart.jsp").forward(request, response);;
				
			}
			
			//ɾ��
			public	boolean deleteCart(int id) {
				return cartService.deleteCart(id);
			}
			
           public void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int id = 0;
				boolean result = false;
				try {
					id = Integer.parseInt(request.getParameter("id"));
					result = deleteCart(id);
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}
				if(result){
					System.out.println("ɾ�����ﳵ�ɹ�");
					findCart(request, response);
				}else {
					System.out.println("ʧ��");
				}

				
			}
			
			
			//�޸�
			public	boolean updateCart(Cart cart ) {
				return cartService.updateCart(cart);
			}
			
			public void updateCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int num = 0;
				int id =0;
				try {
					
					num = Integer.parseInt(request.getParameter("productnum"));
					System.out.println(num);
					
					id = Integer.parseInt(request.getParameter("id"));
					System.out.println(id);
					Cart cart = getCartById(id);
					cart.setProductnum(num);
					boolean result = updateCart(id,num);
					System.out.println("==============");
					if(result) {
						System.out.println("�޸ĳɹ�");
						findCart(request, response);
					}else {
						System.out.println("�޸�ʧ��");
					}
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}
				
				
			}
			/*
			 * ͨ��idѰ�ҹ��ﳵ
			 * */
			public Cart getCartById(int id) {
				
				return cartService.getCartById(id);

			}
			public void getCartById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int id = 0;
				try {
					id = Integer.parseInt(request.getParameter("id"));
					Cart cart = getCartById(id);
					if(cart!=null) {
						request.setAttribute("cart", cart);
						request.getRequestDispatcher("updateCart.jsp").forward(request, response);
					}else {
						System.out.println("fail");
					}
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}
				
				
			}
			
			
			
			
			
			
		 	//��ȡ���ﳵ����Ʒ����
			public int getCartNum(){
				return cartService.getCatrNum();
			}
			
			//����id�޸Ĺ��ﳵ
			public boolean updateCart(int id, int num) {
				return cartService.updateCart(id, num);
			}
			
}

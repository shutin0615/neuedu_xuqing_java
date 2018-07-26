package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;

import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;
@WebServlet("/view/order")
public class OrderController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9126499829921084426L;
	
	OrderService orderService=new OrderServiceImpl();
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getParameter("operation");
		if(operation.equals("1")) {
			createOrder(request,response);
		}else if(operation.equals("2")) {
			findOrder(request,response);
			
		}else if(operation.equals("3")) {
			findOrderItem(request,response);
		}
			
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
	
	/*
	 * 在jsp页面显示订单
	 * */
	
	
	//订单
	public void findOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserOrder> orders = orderService.findOrder();
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("showorder.jsp").forward(request, response);
		
	}

	//订单明细
	public void findOrderItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserOrderItem> items = orderService.findOrderItem();
		request.setAttribute("items", items);
		request.getRequestDispatcher("showorderitem.jsp").forward(request, response);
		
		
	}

	
	
	
	
	
	/*
	 * 下订单
	 * */
	public void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  if(orderService.creatOrder()) {
			System.out.println("下单成功");
		
		findOrder(request,response);
		}else {		
			System.out.println("下单失败");
		}

	}
	public boolean createOrder() {
		
		return orderService.creatOrder();
	}
	
	//查看
	
	public List<UserOrder> findOrder() {
		
		return orderService.findOrder();
	}

	public List<UserOrderItem> findOrderItem() {
		
		return orderService.findOrderItem();
	} 
	 
}

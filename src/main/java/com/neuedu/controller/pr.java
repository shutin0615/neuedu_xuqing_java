package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.dao.ProductDao;
import com.neuedu.impl.ProductDaoImpl;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class pr
 */
@WebServlet("/pr")
public class pr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getParameter("operation");
		if(operation.equals("find")) {
			findPeople(request,response);
		}else if(operation.equals("add")) {
			addProduct(request,response);
		}
		
		
	}

	
	public void findPeople(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ProductService ps = new ProductServiceImpl();
		List<Product> products = ps.findAll();
		//设置UTF-8
	//	response.setContentType("text/html;charset=utf-8");
	//	request.setCharacterEncoding("utf-8");
		//把对象转为JSON字符串，并out出去
		PrintWriter pw = response.getWriter();	
		String json = JSONArray.toJSONString(products);
		
		System.out.println(json);
		pw.print(json);
	}
	
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

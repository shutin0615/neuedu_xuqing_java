package com.neuedu.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

/**
 * Servlet implementation class FrontLoginController
 */
@WebServlet("/front/login.dos")
public class FrontLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	          
	    LoginService  loginService=new LoginServiceImpl();

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String method=request.getParameter("method");
		
		Account acc=loginService.doLogin(username, MD5Utils.GetMD5Code(password));
		
		if(acc!=null) {//登录成功
			
			//将java对象转Gson字符串
			Gson gson=new Gson();
			String gs=gson.toJson(acc);
			
			//将json字符串转成java对象
			Account accs=gson.fromJson(gs, Account.class);
			System.out.println("json---java:"+accs);
			
			//获取输出流
			PrintWriter writer=response.getWriter();
			//调用js的success的方法
			writer.println(method+"("+gs+")");	
			
			
		/**	
			StringBuffer sbuffer=new StringBuffer("{");
			
			//用户名
			sbuffer.append("\"");
			sbuffer.append("username");
			sbuffer.append("\"");
			sbuffer.append(":");
			sbuffer.append("\"");
			sbuffer.append(acc.getUsername());
			sbuffer.append("\"");
			sbuffer.append(",");
			
			//用户名
			sbuffer.append("\"");
			sbuffer.append("password");
			sbuffer.append("\"");
			sbuffer.append(":");
			sbuffer.append("\"");
			sbuffer.append(acc.getPassword());
			sbuffer.append("\"");
			
			sbuffer.append("}");
			
			System.out.println(sbuffer.toString());
			
			//获取输出流
			PrintWriter writer=response.getWriter();
			//调用js的success的方法
			writer.println(method+"("+sbuffer.toString()+")");
			 */
			
			
			
			 
			 
			
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

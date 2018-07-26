package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

@WebServlet("/Login.do")
public class LoginController extends HttpServlet{

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2127867611341493332L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService  loginService=new LoginServiceImpl();
		
		
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Account acc=loginService.doLogin(username, MD5Utils.GetMD5Code(password));
		
		if(acc!=null) {//��¼�ɹ�
			
			Cookie cookie=new Cookie("username",username);
              //Ĭ�ϵ���-1��Ϊ���ñ��棬0Ϊ�������٣�>0Ϊ�����ʱ�䡣7*24*3600����7��
			cookie.setMaxAge(7*24*3600);
			response.addCookie(cookie);
			
			Cookie _cookie=new Cookie("password",MD5Utils.GetMD5Code(password));
			_cookie.setMaxAge(7*24*3600);
			response.addCookie(_cookie);
			//����token����ŵ����ݿ���
			long time=System.currentTimeMillis();
			String token=MD5Utils.GetMD5Code(username+password+time);
			loginService.addToken(token, acc);
			//�ŵ��Ự����
			HttpSession session=request.getSession();
			session.setAttribute("token", token);
         	session.setAttribute("acc", acc);		
			
			
			
			request.getRequestDispatcher("view/home.jsp").forward(request, response);
		}else {//��¼ʧ��
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

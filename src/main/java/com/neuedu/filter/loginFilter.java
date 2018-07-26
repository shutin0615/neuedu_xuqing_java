package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class loginFilter
 */
@WebFilter("/Login.jsp")
public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("===到达过滤器===");
		
		HttpServletRequest _request=(HttpServletRequest)request;
		HttpServletResponse _response=(HttpServletResponse)response;
		
		String username=null;
		String password=null;
		
		Cookie[] cookis=_request.getCookies();
		if(cookis!=null) {
			//增强for循环
			for(Cookie c:cookis) {
				if(c.getName().equals("username")){
					//用户名
					username=c.getValue();
					System.out.println("=======cookie"+username);
				}
				if(c.getName().equals("password")) {
					//密码
					password=c.getValue();
					System.out.println("=======cookiepasseord"+password);
				}
			}
		}
		
		
		if(username!=null&&password!=null&&!username.equals("")&&!password.equals("")) {
			LoginService  loginService=new LoginServiceImpl();
			
			Account acc=loginService.doLogin(username, password);
			if(acc!=null) {
				request.getRequestDispatcher("view/home.jsp").forward(request,response);
				
			}else {
				chain.doFilter(request, response);
			}
			
			
		}else {
			chain.doFilter(request, response);
		}
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

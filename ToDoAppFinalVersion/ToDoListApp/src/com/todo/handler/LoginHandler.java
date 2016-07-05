package com.todo.handler;

import javax.servlet.http.HttpServletRequest;

import com.todo.service.LoginService;
import com.todo.service.impl.LoginServiceImpl;

public class LoginHandler {

	HttpServletRequest request;

	public LoginHandler(HttpServletRequest re) {
		super();
		this.request = re;
	}
	
	public boolean validateLogin(){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginService ls=new LoginServiceImpl();
		
		boolean res= ls.validateLogin(username,password);
		if(res)
			request.getSession().setAttribute("username", username);
		return res;
	}
	
}

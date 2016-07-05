package com.todo.service.impl;

import com.todo.bean.User;
import com.todo.dao.LoginDAO;
import com.todo.dao.impl.LoginDAOImpl;
import com.todo.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public boolean validateLogin(String username, String password) {
		User u=new User();
		u.setUsername(username);
		u.setPassword(password);
		LoginDAO ldao=new LoginDAOImpl();
		return ldao.validateLogin(u);
		
	}

}

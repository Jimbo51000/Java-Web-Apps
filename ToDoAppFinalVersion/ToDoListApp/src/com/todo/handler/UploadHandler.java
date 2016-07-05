package com.todo.handler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.todo.service.UploadService;
import com.todo.service.impl.UploadServiceImpl;

public class UploadHandler {

	public HttpSession session;

	public UploadHandler(HttpSession session) {
		super();
		this.session = session;
	}
	
	public boolean initUpload(){
		UploadService us=new UploadServiceImpl();
		//get the set data from the db from service
		String username=(String)session.getAttribute("username");
		//go through all the layers and set the attribute 
		
		session.setAttribute("taskset", us.getUploadData(username));
		//System.out.println(us.getUploadData(username));
		return true;
	}
	
}

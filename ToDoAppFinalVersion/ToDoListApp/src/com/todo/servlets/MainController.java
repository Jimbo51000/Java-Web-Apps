package com.todo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.bean.Task;
import com.todo.handler.LoginHandler;
import com.todo.handler.TaskHandler;
import com.todo.handler.UploadHandler;


/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}


	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*handles all the main requests and passed to correp handlers*/
		//get the handler type 
		String handler=request.getParameter("handler");
		//check for the appropriate handler
		if("validateLogin".equals(handler)){
			/*Validation Login Handler*/
			LoginHandler lh=new LoginHandler(request);
			if(!lh.validateLogin())//complete her
				requestForwarder(request, response, "login.jsp");
			
		}
		else if("addHandler".equals(handler)){
			System.out.println("add handler called");
			requestForwarder(request, response, "addform.jsp");
		}
		else if("addNewTask".equals(handler)){
			
			//check if the task exists  then enter
			TaskHandler th=new TaskHandler(request);
			Task t=null;
			if((t=th.validateTask())!=null){
				//TaskHandler th=new TaskHandler(request);
				boolean val=th.addNewTask(t);
				//use the val here
				if(val){
					UploadHandler uh=new UploadHandler(request.getSession());
					if(uh.initUpload()){// upload to taskset attribute
						System.out.println("Upload Complete!");
					}
					System.out.println("returned all the way back to controller");
					requestForwarder(request, response, "mainpage.jsp");
				}
				else{
					System.out.println("error in insertion");
				}
			}
			else{
				System.out.println("You have already entered the task or date is before sysdate");
				requestForwarder(request, response, "addform.jsp");
			}
			
		}
		else if("editTask".equals(handler)){
			//validate task
			//if task is good then update it to db
			TaskHandler th=new TaskHandler(request);
			Task t=null;
			int tid=Integer.parseInt(request.getParameter("tid"));
			System.out.println("before edit");
			if((t=th.validateTask())!=null){
				//now edit the task
				t.setTid(tid);
				System.out.println("valid task uploading in edit");
				if(th.editTask(t)){//goes till the db
					
					UploadHandler uh=new UploadHandler(request.getSession());
					if(uh.initUpload()){// upload to taskset attribute
						System.out.println("Upload Complete!");
					}
				System.out.println("Edit Complete");
				//requestForwarder(request, response, "mainpage.jsp");
				}
			}
			requestForwarder(request, response, "mainpage.jsp");
		}
		else if("taskComplete".equals(handler)){
			TaskHandler th=new TaskHandler(request);
			th.setStatus("completed");
			UploadHandler uh=new UploadHandler(request.getSession());
			if(uh.initUpload()){// upload to taskset attribute
				System.out.println("Upload Complete!");
			}
			requestForwarder(request, response, "mainpage.jsp");
		}
		else if("deleteTask".equals(handler)){
			TaskHandler th=new TaskHandler(request);
			th.deleteTask();
			UploadHandler uh=new UploadHandler(request.getSession());
			if(uh.initUpload()){// upload to taskset attribute
				System.out.println("Upload Complete!");
			}
			requestForwarder(request, response, "mainpage.jsp");
		}
		//System.out.println("in the servlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		
		
	}
	private void requestForwarder(HttpServletRequest request,
			HttpServletResponse response,String location) throws ServletException, IOException {
		System.out.println("Dispatch to "+location);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/pages/"+location);
		dispatcher.forward(request, response);
	}

}

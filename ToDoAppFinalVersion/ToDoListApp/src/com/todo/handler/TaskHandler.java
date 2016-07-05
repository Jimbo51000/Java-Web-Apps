package com.todo.handler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import com.todo.bean.Task;
import com.todo.service.TaskService;
import com.todo.service.impl.TaskServiceImpl;
import com.todo.util.DateTimeUtil;
import com.todo.util.TaskValidator;

public class TaskHandler {
	
	HttpServletRequest request;
	public TaskHandler(HttpServletRequest request) {
		super();
		this.request = request;
	}
	public boolean addNewTask(Task t) {
		//testing for parameters
		//String username=(String) request.getSession().getAttribute("username");
		//username is in task
		TaskService ts=new TaskServiceImpl();
		return ts.addNewTask(t);
		
		
	}
	
	public Task validateTask() {
		DateTimeUtil dtu=new DateTimeUtil();
		Task t=null;
		String taskname=request.getParameter("taskname");//taskname
		String date=request.getParameter("taskdate");//taskdate
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		java.util.Date d=null;
		try {
			d=sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}//maybe pass d instead of taskdate into Task object t
		java.sql.Date taskdate=new java.sql.Date(d.getTime());//taskdate
		//System.out.println("The entered taskdate "+taskdate);
		String time=request.getParameter("tasktime");//time
		DateFormat parser=new SimpleDateFormat("hh:mm");
		java.sql.Time tasktime=null;
		try {
			tasktime=new java.sql.Time(parser.parse(time).getTime());//tasktime
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//Check if the entered date and time is valid
		if(!"pending".equals(request.getParameter("taskstatus"))){
			System.out.println("Its not a pending status"+request.getParameter("taskstatus"));
		if(dtu.compareDate(d, dtu.getSystemDate())<0)
			return null;
		else if((dtu.compareDate(d, dtu.getSystemDate())==0)&&dtu.compareTime(tasktime, dtu.getSystemTime())<0)
			return null;
		}
			//System.out.println("The entered tasktime"+tasktime);
			//if valid and continue with the duplicate check
		int priority=Integer.parseInt(request.getParameter("priority"));//priority
		String category=request.getParameter("category");//category
		t=new Task();
		t.setUsername((String)request.getSession().getAttribute("username"));
		t.setTaskname(taskname);
		t.setCategory(category);
		t.setPriority(priority);
		t.setTaskdate(taskdate);
		t.setTasktime(tasktime);
		t.setTaskstatus("todo");
		TaskValidator v=new TaskValidator();
		TreeSet<Task> ts=(TreeSet<Task>) request.getSession().getAttribute("taskset");
		HashSet<Task> th=new HashSet<Task>(ts);
		boolean res=v.taskValidate(t,th);
		if(res){
			ts.add(t);
			//System.out.println("The tree set is "+ts);
			request.getSession().setAttribute("taskset", ts);
			return t;
			}
		else return null;
		
	}
	public boolean editTask(Task t) {
		TaskService ts=new TaskServiceImpl();
		return ts.editTask(t,(String)request.getParameter("option"));
		
	}
	public void setStatus(String status) {
		int tid=Integer.parseInt(request.getParameter("tid"));
		TaskService ts=new TaskServiceImpl();
		ts.setStatus(tid,status);
		
	}
	public void deleteTask() {
		int tid=Integer.parseInt(request.getParameter("tid"));
		TaskService ts=new TaskServiceImpl();
		ts.deleteTask(tid);
	}

}

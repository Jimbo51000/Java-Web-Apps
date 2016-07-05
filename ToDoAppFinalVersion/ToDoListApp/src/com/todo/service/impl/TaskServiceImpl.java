package com.todo.service.impl;

import com.todo.bean.Task;
import com.todo.dao.TaskDAO;
import com.todo.dao.impl.TaskDAOImpl;
import com.todo.service.TaskService;

public class TaskServiceImpl implements TaskService{

	@Override
	public boolean addNewTask(Task task) {
		TaskDAO tdao=new TaskDAOImpl();
		return tdao.addNewTask(task);
	}

	@Override
	public boolean editTask(Task task, String option) {
		TaskDAO tdao=new TaskDAOImpl();
		return tdao.editTask(task,option);
		
	}

	@Override
	public void setStatus(int tid,String status) {
		TaskDAO tdao=new TaskDAOImpl();
		tdao.setStatus(tid,status);
		
	}

	@Override
	public void deleteTask(int tid) {
		TaskDAO tdao=new TaskDAOImpl();
		tdao.deleteTask(tid);
		
	}

}

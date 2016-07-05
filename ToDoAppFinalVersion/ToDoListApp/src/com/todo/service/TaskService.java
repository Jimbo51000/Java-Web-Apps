package com.todo.service;

import com.todo.bean.Task;

public interface TaskService {

	public boolean addNewTask(Task task);
	public boolean editTask(Task task,String option);
	public void setStatus(int tid,String status);
	public void deleteTask(int tid);
}

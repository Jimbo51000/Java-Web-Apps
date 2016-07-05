package com.todo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.todo.bean.Task;
import com.todo.dao.TaskDAO;
import com.todo.db.SQLConnUtil;
import com.todo.handler.UploadHandler;

public class TaskDAOImpl implements TaskDAO{

	@Override
	public boolean addNewTask(Task task) {
		//add to database and call the upload handler to set
		String query="insert into tasks(username,taskname,category,taskdate,tasktime,priority,taskstatus) values (?,?,?,?,?,?,'todo')";
		SQLConnUtil sqlcon=SQLConnUtil.getInstance();
		Connection con=sqlcon.openConnection();
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, task.getUsername());
			ps.setString(2, task.getTaskname());
			ps.setString(3, task.getCategory());
			java.util.Date date=task.getTaskdate();
			ps.setDate(4, (Date) task.getTaskdate());//maybe error here later on
			ps.setTime(5, task.getTasktime());
			ps.setInt(6, task.getPriority());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error in taskdaoimpl maybe the prepared stmt");
			e.printStackTrace();
			return false;
		}
		System.out.println("The task has been inserted into the db");
		System.out.println("Starting to upload..");
		
		return true;
		
	}

	@Override
	public boolean editTask(Task task, String option) {
		String value=null;
		boolean flag=false;
		if(option.equals("priority")){
			value=""+task.getPriority();
			flag=true;
		}
		if(option.equals("taskname")){
			value=task.getTaskname();
		}else if(option.equals("taskdate")){
			value=""+task.getTaskdate();
		}else if(option.equals("tasktime")){
			value=""+task.getTasktime();
		}else if(option.equals("category")){
			value=task.getCategory();
		}
		
		String query=null;
		if(flag)
			query="update tasks set "+option+"="+value+" where tid="+task.getTid();
		else
			query="update tasks set "+option+"='"+value+"' where tid="+task.getTid();
		SQLConnUtil sqlcon=SQLConnUtil.getInstance();
		if(sqlcon.runUpdateQuery(query))
			return true;
		else 
			return false;
		
	}

	@Override
	public void setStatus(int tid, String status) {
		String query="update tasks set taskstatus='"+status+"' where tid="+tid;
		SQLConnUtil sqlcon=SQLConnUtil.getInstance();
		if(sqlcon.runUpdateQuery(query))
			System.out.println("Task completed");
		else 
			System.out.println("error in status updation");
		
	}

	@Override
	public void deleteTask(int tid) {
		String query="delete from tasks where tid="+tid;
		SQLConnUtil sqlcon=SQLConnUtil.getInstance();
		if(sqlcon.runUpdateQuery(query))
			System.out.println("Task deleted");
		else 
			System.out.println("error in task  deletion");
		
	}

}

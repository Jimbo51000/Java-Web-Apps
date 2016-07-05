package com.todo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.todo.bean.Task;
import com.todo.dao.CheckStatusDAO;
import com.todo.dao.UploadDAO;
import com.todo.db.SQLConnUtil;
import com.todo.util.Converter;

public class UploadDAOImpl implements UploadDAO{

	@Override
	public List<Task> getUploadData(String username) {
		//get the db instance
		SQLConnUtil sqlcon=SQLConnUtil.getInstance();
		CheckStatusDAO csdao=new CheckStatusDAOImpl();
		boolean change=false;
		try {
			change=csdao.checkTaskStatus(username);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
/*		if(change)
			System.out.println("There are new tasks pending");
		else
			System.out.println("There are no new pending tasks");*/
		String query="select * from tasks where username='"+username+"'";
		//get the resultset object
		ResultSet rs=sqlcon.runSelectQuery(query);
		
		//convert it to set via another converter class
		List<Task> set=Converter.convertToSet(rs);
		sqlcon.closeConnection();
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return back the set to service
		return set;
		
	}

}

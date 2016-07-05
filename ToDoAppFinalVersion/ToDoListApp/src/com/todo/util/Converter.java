package com.todo.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todo.bean.Task;

public class Converter {
	
	public static List<Task> convertToSet(ResultSet rs){
		List<Task> st=new ArrayList<Task>();
		//convert here
		
		
		Task t=null;
		try {
			while(rs.next()){
				//get each row in loop of rs and create bean
				t=new Task();
				//TODO
				//add bean to set
				t.setTid(rs.getInt("tid"));
				t.setUsername(rs.getString("username"));
				t.setTaskname(rs.getString("taskname"));
				t.setCategory(rs.getString("category"));
				t.setTaskdate(rs.getDate("taskdate"));//check here for error
				t.setTasktime(rs.getTime("tasktime"));//here too
				t.setPriority(rs.getInt("priority"));
				t.setGroupid(rs.getInt("groupid"));
				t.setTaskstatus(rs.getString("taskstatus"));
				st.add(t);
			}
			return st;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

}

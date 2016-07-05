package com.todo.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.todo.dao.CheckStatusDAO;
import com.todo.db.SQLConnUtil;
import com.todo.util.DateTimeUtil;

public class CheckStatusDAOImpl implements CheckStatusDAO {

	@Override
	public boolean checkTaskStatus(String username) throws SQLException {
		String query = null;
		boolean flag = false;
		//query = "select * from tasks where username='" + username
				//+ "' and taskstatus='todo'";
		query="select * from tasks where username='"+username+"'";
		SQLConnUtil sqlcon = SQLConnUtil.getInstance();
		ResultSet rs = sqlcon.runSelectQuery(query);
		// The current system date and time
		/*
		 * flag = true; rs.updateString("taskstatus", "pending");
		 * rs.updateRow();
		 */
		DateTimeUtil dtu=new DateTimeUtil();
		java.util.Date sysDate = dtu.getSystemDate();
		java.sql.Time sysTime=dtu.getSystemTime();
		while (rs.next()) {
			// This step is important
			java.util.Date taskdate = rs.getDate("taskdate");
			java.sql.Time tasktime = rs.getTime("tasktime");
			if("completed".equals(rs.getString("taskstatus"))){
				continue;
			}
			
			if(dtu.compareDate(taskdate, sysDate)>0){
				//flag = true; 
				rs.updateString("taskstatus", "todo");
				rs.updateRow();
			}
			else if(dtu.compareDate(taskdate, sysDate)==0){
				if(dtu.compareTime(tasktime, sysTime)>0){
					flag = true; 
					rs.updateString("taskstatus", "todo");
					rs.updateRow();
				}
			}
			
			if(dtu.compareDate(taskdate, sysDate)<0){
				flag = true; 
				rs.updateString("taskstatus", "pending");
				rs.updateRow();
			}
			else if(dtu.compareDate(taskdate, sysDate)==0){
				if(dtu.compareTime(tasktime, sysTime)<0){
					flag = true; 
					rs.updateString("taskstatus", "pending");
					rs.updateRow();
				}
			}

		}
		sqlcon.closeConnection();
		return flag;

	}

	public static void main(String[] args) throws Exception {

		CheckStatusDAOImpl da = new CheckStatusDAOImpl();
		da.checkTaskStatus("jimmy");

	}

}

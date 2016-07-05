package com.todo.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.todo.bean.User;
import com.todo.dao.LoginDAO;
import com.todo.db.SQLConnUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean validateLogin(User user) {
		SQLConnUtil sqlcon = SQLConnUtil.getInstance();
		/*
		 * Get the db instance
		 * 
		 * Open connection and execute the query
		 */
		Connection con = sqlcon.openConnection();
		String query = "select * from user where username=? and password=?";
		ResultSet rs = null;
		PreparedStatement p = null;
		boolean res=false;
		try {
			p = con.prepareStatement(query);
			p.setString(1, user.getUsername());
			p.setString(2, user.getPassword());
			rs = p.executeQuery();
			while(rs.next()){
				//System.out.println(rs.getString("username")+","+rs.getString("password"));
				res=true;
			}
			p.close();
			//con.close();
			sqlcon.closeConnection();
			// check the resultset object for null
	
		} catch (SQLException e) {
			System.out.println("Error in validate logindaoimpl");
			e.printStackTrace();
		}
		
		return res;
		
	}

}

package com.todo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SQLConnUtil {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/mydb";
	private  Connection con;
	private  String sql;
	private  Statement st;
	private  ResultSet rs;
	
	private static SQLConnUtil sqlconn_util;
	
	static {
		try {
			Class.forName(driver);

			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not loaded");

			e.printStackTrace();

		}
	}
	
	
	
	public static SQLConnUtil getInstance() {
		if (sqlconn_util == null)
			sqlconn_util = new SQLConnUtil();

		return sqlconn_util;
	}
	
	
	public Connection openConnection() {
		try {
			if (con == null || con.isClosed())
				con = DriverManager.getConnection(url,"root","root");
			//System.out.println("Connection Established");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
				//st.close();//some different error
				//rs.close();//same here 
				//System.out.println("Connection closed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ResultSet runSelectQuery(String query){
		SQLConnUtil s = SQLConnUtil.getInstance();
		ResultSet r = null;
		con=s.openConnection();
		try {
			  st = con.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery(query);
			//check for close constraints

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	public boolean runUpdateQuery(String query){
		SQLConnUtil s = SQLConnUtil.getInstance();
		
		int ret=0;
		con=s.openConnection();
		try {
			st=con.createStatement();
			ret=st.executeUpdate(query);
			//check for close constraints

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(query);
			e.printStackTrace();
		}
		//System.out.println(query);
		if(ret>=1)
			return true;
		else 
			return false;
		
		
	}
	
}

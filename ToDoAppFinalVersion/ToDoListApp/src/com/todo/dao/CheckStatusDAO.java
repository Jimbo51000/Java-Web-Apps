package com.todo.dao;

import java.sql.SQLException;

public interface CheckStatusDAO {

	public boolean checkTaskStatus(String username) throws SQLException;
}

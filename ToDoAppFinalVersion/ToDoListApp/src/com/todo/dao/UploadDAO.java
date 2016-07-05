package com.todo.dao;

import java.util.List;

import com.todo.bean.Task;

public interface UploadDAO {

	List<Task> getUploadData(String username);
	
}

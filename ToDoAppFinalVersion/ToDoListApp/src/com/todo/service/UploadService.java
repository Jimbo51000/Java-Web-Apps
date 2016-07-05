package com.todo.service;

import java.util.Set;

import com.todo.bean.Task;

public interface UploadService {
	
	public Set<Task> getUploadData(String username);

}

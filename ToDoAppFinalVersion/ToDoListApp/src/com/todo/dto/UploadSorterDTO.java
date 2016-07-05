package com.todo.dto;

import java.util.List;
import java.util.Set;

import com.todo.bean.Task;

public interface UploadSorterDTO {
	
	List<Task> sortAndUpload(String username);
	Set<Task> convert(List<Task> tasklist);
}

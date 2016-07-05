package com.todo.service.impl;

import java.util.List;
import java.util.Set;

import com.todo.bean.Task;
import com.todo.dto.UploadSorterDTO;
import com.todo.dto.impl.UploadSorterDTOImpl;
import com.todo.service.UploadService;

public class UploadServiceImpl implements UploadService{

	@Override
	public Set<Task> getUploadData(String username) {
		//go to dto sorter
		UploadSorterDTO us=new UploadSorterDTOImpl();
		List<Task> tasklist=us.sortAndUpload(username);
		/*System.out.println("list tasklist");
		System.out.println(tasklist);
		System.out.println("something else");
		*/return us.convert(tasklist);//convert from list to set in dto
		//return null;
		
	}

	
}

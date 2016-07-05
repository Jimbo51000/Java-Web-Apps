package com.todo.dto.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.todo.bean.Task;
import com.todo.dao.UploadDAO;
import com.todo.dao.impl.UploadDAOImpl;
import com.todo.dto.UploadSorterDTO;
import com.todo.util.MyComparator;

public class UploadSorterDTOImpl implements UploadSorterDTO{
	/*
	 * (non-Javadoc)
	 * @see com.todo.dto.UploadSorterDTO#sortAndUpload()
	 * 
	 * The sort function can be changed to use only the TreeSet collection implemented with the Comparator
	 */
	@Override
	public List<Task> sortAndUpload(String username) {
		//List<Task> l=new ArrayList<>
		UploadDAO udao=new UploadDAOImpl();
		List<Task> tasklist=udao.getUploadData(username);//get from the dao;
		//Collections.sort(list, new);
		Collections.sort(tasklist, new Comparator<Task>() {

			@Override
			public int compare(Task o1, Task o2) {
				int d=0;
				if(o1.getTaskdate()==null||o2.getTaskdate()==null)
					return 0;
				
				d=o1.getTaskdate().compareTo(o2.getTaskdate());
				
				
				if(d==0){
					//compare time
					int t=o1.getTasktime().compareTo(o2.getTasktime());
					if(t==0){
						return 0;
					}
					else if(t<0)
						return -1;
					else if(t>0)
						return 1;
				}
				
				
				//return t;
				return d;
				
			}
			
		});
		return tasklist;
		
	}

	@Override
	public Set<Task> convert(List<Task> tasklist) {
		
		Set<Task> st=new TreeSet<Task>(new MyComparator());
		for(Task t:tasklist){
			st.add(t);
		}
//		Set<Task> st=new LinkedHashSet<Task>();
//		for(Task t:tasklist){
//			st.add(t);
//		}
		return st;
		
	}

}

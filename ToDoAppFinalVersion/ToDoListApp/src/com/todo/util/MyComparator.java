package com.todo.util;

import java.util.Comparator;

import com.todo.bean.Task;

public class MyComparator implements Comparator<Task>{

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
				return 1;
			}
			else if(t<0)
				return -1;
			else if(t>0)
				return 1;
		}
		
		
		//return t;
		return d;
	}

}

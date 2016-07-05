package com.todo.util;

import java.util.HashSet;

import com.todo.bean.Task;

public class TaskValidator {
	
	public boolean taskValidate(Task t,HashSet<Task> taskset){
		boolean res=false;
		//System.out.println("The Old HashSet is"+taskset);
		//System.out.println(t);
		if(taskset.add(t)){
			res=true;
			//System.out.println("new incoming task");
		}
		else{
			//System.out.println("Old task");
			res=false;
		}
		//System.out.println("The new hash set is "+taskset);
		return res;
	}

}

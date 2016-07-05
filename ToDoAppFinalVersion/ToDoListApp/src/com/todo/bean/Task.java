package com.todo.bean;

import java.io.Serializable;
import java.util.Date;
import java.sql.Time;

import com.todo.util.DateTimeUtil;

public class Task implements Serializable{

	private int tid;
	private String username;
	private String taskname;
	private String category;
	private Date taskdate;
	private Time tasktime;
	private int priority;
	private int groupid;
	private String taskstatus;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result=username.hashCode()*taskname.hashCode()*category.hashCode()*taskdate.hashCode()*tasktime.hashCode()*priority;
/*		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + groupid;
		result = prime * result + priority;
		result = prime * result
				+ ((taskdate == null) ? 0 : taskdate.hashCode());
		result = prime * result
				+ ((taskname == null) ? 0 : taskname.hashCode());
		result = prime * result
				+ ((taskstatus == null) ? 0 : taskstatus.hashCode());
		result = prime * result
				+ ((tasktime == null) ? 0 : tasktime.hashCode());
		result = prime * result + tid;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());*/
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		/*if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (groupid != other.groupid)
			return false;
		if (priority != other.priority)
			return false;
		if (taskdate == null) {
			if (other.taskdate != null)
				return false;
		} else if (!taskdate.equals(other.taskdate))
			return false;
		if (taskname == null) {
			if (other.taskname != null)
				return false;
		} else if (!taskname.equals(other.taskname))
			return false;
		if (taskstatus == null) {
			if (other.taskstatus != null)
				return false;
		} else if (!taskstatus.equals(other.taskstatus))
			return false;
		if (tasktime == null) {
			if (other.tasktime != null)
				return false;
		} else if (!tasktime.equals(other.tasktime))
			return false;
		if (tid != other.tid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;*/
		DateTimeUtil dtu=new DateTimeUtil();
		//if(this.username.equals(other.username)&&this.category.equals(other.category)&&this.taskname.equals(other.taskname)&&this.taskdate.compareTo(other.taskdate)==0&&this.tasktime.compareTo(other.tasktime)==0)
		if(this.priority==other.priority&&this.username.equals(other.username)&&this.category.equals(other.category)&&this.taskname.equals(other.taskname)&&dtu.compareDate(this.taskdate, other.taskdate)==0&&dtu.compareTime(tasktime, other.tasktime)==0)
			return true;
		else
			return false;
	}

	public Task() {
		super();
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getTaskdate() {
		return taskdate;
	}
	public void setTaskdate(Date taskdate) {
		this.taskdate = taskdate;
	}
	public Time getTasktime() {
		return tasktime;
	}
	public void setTasktime(Time tasktime) {
		this.tasktime = tasktime;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	@Override
	public String toString() {
		return "Task [tid=" + tid + ", username=" + username + ", taskname="
				+ taskname + ", category=" + category + ", taskdate="
				+ taskdate + ", tasktime=" + tasktime + ", priority="
				+ priority + ", groupid=" + groupid + ", taskstatus="
				+ taskstatus + "]\n";
	}
}

package com.todo.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeUtil {

	public java.util.Date getSystemDate(){
		java.util.Date date=new java.util.Date(); // your date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    String somedate=year+"-"+(month+1)+"-"+day;
		
		java.util.Date curDate=null;
		try {
			curDate = sdf.parse(somedate);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return curDate;
	}
	
	public java.sql.Time getSystemTime(){
		java.util.Date today = new java.util.Date();
		java.sql.Time curTime = new java.sql.Time(today.getTime());
		return curTime;
	}
	
	public int compareDate(java.util.Date curDate, java.util.Date d) {
		
		if(curDate.compareTo(d)>0){
			//System.out.println("Date1 is after Date2");
			return 1;
    	}else if(curDate.compareTo(d)<0){
    		//System.out.println("Date1 is before Date2");
    		return -1;
    	}else if(curDate.compareTo(d)==0){
    		//System.out.println("Date1 is equal to Date2");
    		return 0;
    	}else{
    		System.out.println("How to get here?");
    		return 0;
    	}
		
	}
	
	public int compareTime(java.sql.Time curTime,java.sql.Time t){
		if(curTime.getHours()>t.getHours()){
			//System.out.println("Time1 is after Time2");
			return 1;
		}
		else if(curTime.getHours()<t.getHours()){
			//System.out.println("Time1 is before Time2");
			return -1;
		}
		else if(curTime.getHours()==t.getHours()){
			if(curTime.getMinutes()<t.getMinutes()){
				//System.out.println("Time1 is before Time2");
				return -1;
			}
			else if(curTime.getMinutes()>t.getMinutes()){
				//System.out.println("Time1 is after Time2");
				return 1;
			}
			else{
				//System.out.println("Time1 is equal to Time2");
				return 0;
			}
				
		}else{
			return 0;
		}
		
	}
}

package com.jsj.hn.DUBtils;

import java.util.Calendar;

public class Clock {
	private int h;
	private int m;
	private int s;
	public int getH() {
		Calendar calendar=Calendar.getInstance();    
		return calendar.HOUR_OF_DAY;
	}
	
	public int getM() {
		Calendar calendar=Calendar.getInstance();    
		return calendar.MINUTE;
	}
	
	public int getS() {
		Calendar calendar=Calendar.getInstance();    
		return calendar.SECOND;
	}
	
	
}

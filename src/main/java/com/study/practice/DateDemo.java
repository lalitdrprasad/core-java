package com.study.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy hh:mm:ss:SS a");
		
		System.out.println(sdf.format(new Date()));
		
		Date date = new Date();
		System.out.println(date);
		
		
	}

}

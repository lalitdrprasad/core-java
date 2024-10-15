package com.practice;

public class ExceptionDemo {
	public static void main(String[] args) {
		int x = 5, y = 0;
		
		try{
			System.out.println(x/y);
		}
		finally{
			System.out.println("Exception Occured");
		}
	}
}

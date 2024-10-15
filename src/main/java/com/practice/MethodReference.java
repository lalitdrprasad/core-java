package com.practice;


interface PrintSomthing{
	void print(String msz);
}

public class MethodReference {

	static void display(String msz){
		System.out.println(msz);
	}
	public static void main(String[] args) {
		
		PrintSomthing ps = MethodReference::display;
		ps.print("MSZ");
	}
	
}

package com.static_demo;
public class StaticBlock {
	static {
		show();
	}
		
	static void show() {
		System.out.println("This is Show Method");
	}
	
	public static void main(String args[]) {
		System.out.println("Hello main");
	}
}

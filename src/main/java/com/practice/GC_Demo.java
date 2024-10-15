package com.practice;

public class GC_Demo {
	@Override
	protected void finalize() {
		System.out.println(this.hashCode() +" has been removed");
	}
	public static void main(String[] args) {
		GC_Demo demo1 = new GC_Demo();
		GC_Demo demo2 = new GC_Demo();
		
		demo1 = null;
		demo2 = null;
		
		System.gc(); // This code will execute after the execution of the print statements.
		
		System.out.println(demo1);
		System.out.println(demo2);
		
	}
}

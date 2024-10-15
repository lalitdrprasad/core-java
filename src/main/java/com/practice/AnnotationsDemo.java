package com.practice;

class Test {
	public void m1() {
		System.out.println("This is m1");
	}

	@Deprecated
	public void m2() {
		System.out.println("This is m2 and is deprecated");
	}
}

public class AnnotationsDemo extends Test{
	@Override
	public void m1(){
		System.out.println("This is m1 and is overrided");
	}
	
	public static void main(String []args){
		Test t = new Test();
		AnnotationsDemo obj = new AnnotationsDemo();
		t.m1();
		obj.m1();
		
		obj.m2();
		
	}
	
}

package com.study.practice;

//Avoid Class cast exception
class MyGen<T> {

	public MyGen(T t) {
		super();

		System.out.println(t);
	}

}

public class Generic {
	public static void main(String[] args) {
		new MyGen(null);
		new MyGen(new Integer(10));
		new MyGen(new String("Lalit"));
		new MyGen(new Float(6f));
		new MyGen(new Boolean(false));
	}
}

package com.study.practice;

interface A {

	static int x = 0; // By Default Public and Final
	int y = 9; // By Default Public and Final

	void a();// by default, public and abstract

	void b();

	void c();

	static void d() {
		System.out.println("This is Static");
	}

	default void e() {

	}

}

// Creating abstract class that provides the implementation of one method of A
// interface
abstract class B implements A {
	@Override
	public void c() {
		System.out.println("I am C");
	}
}

// Creating subclass of abstract class, now we need to provide the
// implementation of rest of the methods
class M extends B {
	@Override
	public void a() {

		System.out.println("I am a");
	}

	@Override
	public void b() {
		System.out.println("I am b");
	}

	@Override
	public void e() {
		System.out.println("I am e");
	}
}

// Creating a test class that calls the methods of A interface
public class InterfaceDemo {
	public static void main(String args[]) {
		A a = new M();
		a.a();
		a.b();
		a.c();
		A.d();
		a.e();
	}
}
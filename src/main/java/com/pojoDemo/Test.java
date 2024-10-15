package com.pojoDemo;

public class Test {
	static int i = 0;

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.seteId(111);
		e1.seteName("Lalit");
		e1.setSalary(30000);

		System.out.println(e1.geteId());
		System.out.println(e1.geteName());
		System.out.println(e1.getSalary());
	}
}

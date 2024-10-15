package com.proxyDemo;

public class MainClass {
	public static void main(String[] args) {

		IEmployee emp = ITEmployee.getItEmployee(101, 50000d);
		emp.salHike(5000d);
		System.out.println(emp.getSalary());
		System.out.println(emp.getId());
	}
}

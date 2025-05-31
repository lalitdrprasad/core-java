package com.study.generics;

public class TestGenerics {
	public static <T extends Person> T createInstance(Class<T> classs) throws Exception {

		return (T) classs.getDeclaredConstructor(new Class[] {}).newInstance();

	}

	public static void main(String[] args) throws Exception {
		System.out.println(createInstance(Student.class));
		System.out.println(createInstance(Employee.class));
		// System.out.println(createInstance(Date.class)); 
		// This_is_not_person_type_class 

	}
}

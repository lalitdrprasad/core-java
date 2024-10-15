package com.clonning_equals;

public class Student implements Cloneable {

	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) throws CloneNotSupportedException {

		Student s1 = new Student("Rahul", 30);
		Student s2 = (Student) s1.clone();
		Student s3 = s1;
		System.out.println("s1.equals(s2) : " + (s1.equals(s2)));
		System.out.println("s1==s2 : " + (s1 == s2));
		System.out.println("s1.equals(s3) : " + (s1.equals(s3)));
		System.out.println("s1==s3 : " + (s1 == s3));
		System.out.println("S1 Hashcode : " + s1.hashCode());
		System.out.println("S2 Hashcode : " + s2.hashCode());
		System.out.println("S3 Hashcode : " + s3.hashCode());
		System.out.println(s1 + "\n" + s2);
	}
}

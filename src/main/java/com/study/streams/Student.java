package com.study.streams;

public class Student {
	private String name;
	private int id;
	private char grade;
	private int marks;

	public Student(String name, int id, char grade,int marks) {
		this.name = name;
		this.id = id;
		this.grade = grade;
		this.marks = marks;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public char getGrade() {
		return grade;
	}

	// Setters (if needed)
	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", id=" + id + ", grade=" + grade + '}';
	}
}
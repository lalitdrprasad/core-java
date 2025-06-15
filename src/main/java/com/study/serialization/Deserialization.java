package com.study.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialization {

	public static Employee deserialize(String path) {
		Employee emp = null;

		try (FileInputStream fileIn = new FileInputStream(path); ObjectInputStream in = new ObjectInputStream(fileIn)) {

			emp = (Employee) in.readObject();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return emp;
	}

	public static void main(String[] args) {
		
		System.out.println("Deserialization Done? : " + deserialize("employee.ser"));
	}
}

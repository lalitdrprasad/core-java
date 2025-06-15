package com.study.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialization {

	public static boolean serialize(Employee emp) {

		try (FileOutputStream fileOut = new FileOutputStream("employee.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

			out.writeObject(emp);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		Employee emp = new Employee.Builder().id(1).name("Lalit").department("IT").salary(75000.50).build();
		System.out.println("Object Serialized? : " + serialize(emp));
	}
}

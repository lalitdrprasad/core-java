package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadLInes {
	public static void main(String[] args) throws FileNotFoundException {
		String line = "";
		FileInputStream fis = new FileInputStream("source");
		Scanner scanner = new Scanner(fis);
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			System.out.println(line);
		}
		System.out.println(line);
		scanner.close();
	}
}

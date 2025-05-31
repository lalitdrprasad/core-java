package com.study.fileoperations;

import java.io.File;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) throws IOException {
		File file = new File("File1.txt");
		file.createNewFile();
		System.out.println("File Created");
	}
}

package com.study.fileoperations;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOS {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("FOS.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String str = "This was written with the help of BufferedOutputStream.for that we took help of FileOutputStream object because BufferedOutputStream object does not directly communicate with the file so .";
		byte[] b = str.getBytes();
		bos.write(b);
		bos.close();
		fos.close();
		System.out.println("String have been written into the file");
	}
}

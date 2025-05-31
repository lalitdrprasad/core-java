package com.study.fileoperations;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteIntoFile {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("FOS.txt"); //Will Create new file if not exist.
		fos.write('L');
		fos.write('A');
		fos.write('L');
		fos.write('I');
		fos.write('T');
		fos.close();
	}
}

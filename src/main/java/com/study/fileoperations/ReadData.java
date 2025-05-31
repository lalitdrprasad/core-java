package com.study.fileoperations;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadData {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("FOS.txt");
		fis.read();
		
		int c;
		while((c=fis.read())!=-1){
			System.out.print((char)c);
		}
		fis.close();
	}

}

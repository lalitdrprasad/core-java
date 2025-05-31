package com.study.fileoperations;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedIS {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("FOS.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		int c;
		while((c=bis.read())!=-1){
			System.out.print((char)c);
		}
		bis.close();
		fis.close();
	}
}

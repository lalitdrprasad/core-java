package com.practice;

import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PrintDemo {
	public static void main(String args[]) {
	    try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512)) {
			out.write("test string");
			out.write('\n');
			out.flush();
		}
	    catch(IOException e) {
	    	
	    }
	 }
}

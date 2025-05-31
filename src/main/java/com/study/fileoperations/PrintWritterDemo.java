package com.study.fileoperations;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWritterDemo{
  // Used to write object's data on console and in a file.
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		pw.write("Print on colsole");
		pw.close();
		
		pw = new PrintWriter("FOS.txt");
		pw.write("Print Writer Demo");
		pw.close();
	}

}

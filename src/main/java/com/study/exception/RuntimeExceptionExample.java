package com.study.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RuntimeExceptionExample {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Make sure this file exists or adjust the path

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}

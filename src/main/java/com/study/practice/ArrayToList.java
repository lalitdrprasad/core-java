package com.study.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayToList {

	static List<Integer> convert(int []ar){
		
		List<Integer> list = new ArrayList<Integer>();
		for(int x: ar){
			list.add(x);
		}
		return list;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Size of Array : ");
		int size = sc.nextInt();
		int ar[] = new int[size];
		System.out.println("Enter the elements");
		for(int i=0;i<size;i++){
			ar[i] = sc.nextInt();
		}
		System.out.println(convert(ar));
		sc.close();
	}

}

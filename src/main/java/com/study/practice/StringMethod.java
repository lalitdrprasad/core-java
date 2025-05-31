package com.study.practice;

public class StringMethod
{
	public static void main(String args[])
	{
		String s="java";
		String s1="java";
		String s2="JAVA";
		String s3="  this is java program  ";
		System.out.println("output of s1.charAt(3) : "+s1.charAt(3));
		char ar[]=s1.toCharArray();
		System.out.println("output of s1.toCharArray()");
		for(char a :ar)
		System.out.println(a);
		byte b[]=s1.getBytes();
		System.out.println("output of s1.getBytes()");
		for(byte bt:b)
		System.out.println(bt);
		System.out.println("output of s1.toUpperCase : "+s1.toUpperCase());
		System.out.println("output of s2.toLowerCase() : "+s2.toLowerCase());
		System.out.println("output of s3.trim() : "+s3.trim());
		System.out.println("output of s1.starsWith(j) : "+s1.startsWith("j"));
		System.out.println("output of s1.endsWith(a) : "+s1.endsWith("a"));
		System.out.println("output of s1.length() : "+s1.length());
		System.out.println("output of s1.equals(s) and s1.equals(s2) : "+s1.equals(s)+","+s1.equals(s2));
		System.out.println("output of s1.equalsIgnoreCase(s2) : "+s1.equalsIgnoreCase(s2));
		System.out.println("output of s3.indexOf(i) : "+s3.indexOf("i"));
		System.out.println("output of s3.indexOf(i,5) : "+s3.indexOf("i",5));
		System.out.println("output of s3.substring(6) : "+s3.substring(6));
		System.out.println("output of s3.substring(6,8) : "+s3.substring(6,8));
		System.out.println("output of s3.replace(a,*) : "+s3.replace("a","*"));
		System.out.println("output of s2.split(s3) : "+s2.split(s3));
	}
}
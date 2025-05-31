package com.study.exception;

public class Main{  
    public static void main(String []args){  
       try{  
           int a = 1; 
           
           System.out.println(a/0);  
       }  
       catch(ArithmeticException e) {
    	   System.out.println("Exception : Can't divide by zero"); 
       }
       finally  
       {  
           System.out.println("rest of the code...");  
       } 
    }  
}  
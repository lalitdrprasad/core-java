package com.study.abstracts;
//declaring the static variables and methods in an abstract class.
abstract class Demo  
{  
    static int i = 102;  
    static void TestMethod()  
    {  
        System.out.println("hi !! I am good !!");  
    } 
}  
public class TestImplementaion extends Demo   
{  
    public static void main (String args[])  
    {  
        Demo.TestMethod();  
        System.out.println("i = "+Demo.i);
    }
}  

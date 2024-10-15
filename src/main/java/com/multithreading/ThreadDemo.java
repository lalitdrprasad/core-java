package com.multithreading;

public class ThreadDemo extends Thread
{
	ThreadDemo()
	{
		start();
	}
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println("From "+Thread.currentThread().getName()+ " : "+i);
		}
	}
	public static void main(String args[]) throws Exception
	{
		
		System.out.println("Start Main");
		new ThreadDemo().setName("0");
		new ThreadDemo().setName("1");
		new ThreadDemo().setName("2");
		
		System.out.println("End Main");
	}
}
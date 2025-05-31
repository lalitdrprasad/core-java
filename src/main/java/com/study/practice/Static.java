package com.study.practice;
public class Static {
	static int var;
	static {
		System.out.println("This is static block");
	}
	
	int setVar(int i){
		var = i;
		return var;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		char c = 'D';
		int ar[] = new int[0];
		System.out.println(ar.length);
		char d=84;
		c++;d++;
		System.out.println(d);
		System.out.println(c);
		
		
				
		//Static obj = new Static();
		//System.out.println(obj.setVar(5));
	}
}


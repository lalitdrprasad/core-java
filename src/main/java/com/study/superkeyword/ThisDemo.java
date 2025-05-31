package com.study.superkeyword;
class ABC{
	int i = 0;
	
	ABC(){
		System.out.println("This is ABC");
	}
}
class XYZ extends ABC{
	int i = 1;
	
	XYZ(){		
		System.out.println("This is XYZ");
		System.out.println("this.i : "+this.i);
		System.out.println("super.i : "+super.i);
	}
}
public class ThisDemo{
	public static void main(String[] args) {
		new XYZ();
	}
}

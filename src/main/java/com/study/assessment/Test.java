package com.study.assessment;
public class Test{
	
	public static void main(String args[]){
		
		int ar[] = {10,5,8,2,50,30,100};
		
		int max1=0,max2=0;
		
		for(int i=0;i<ar.length;i++){
			if(ar[i]>max1){
				max1=ar[1];
 			}
			else if(ar[i]>max2){
				max2=ar[i];
			}
		}
		System.out.print(max2);
		
	}
}
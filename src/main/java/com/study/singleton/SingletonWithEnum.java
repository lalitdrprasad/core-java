package com.study.singleton;

enum EnumSingleton {
	INSTANCE;

	private int count = 0;

	int getCount() {
		return ++count;
	}
}

public class SingletonWithEnum {
	public static void main(String[] args) {

		EnumSingleton singleton = EnumSingleton.INSTANCE;
		System.out.println(singleton.getCount());
		System.out.println(singleton.getCount());
		System.out.println(singleton.getCount());
		System.out.println(singleton.getCount());
	
	}
}

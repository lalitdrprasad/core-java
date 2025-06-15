package com.study.enumeration;

public class EnumInClass {

	enum days {
		SUN, MON, TUE, WED, THU, FRI, SAT
	};

	public static void main(String[] args) {
		for (days d : days.values()) {
			System.out.println(d);
		}
	}
}

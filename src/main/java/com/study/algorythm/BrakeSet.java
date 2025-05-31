package com.study.algorythm;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BrakeSet {
	private static final int brakePaddles = 1;
	private static final int brakeCables = 1;
	private static final int levers = 2;
	private static final int brakeShoes = 2;

	static Map<String, Integer> brakeSetParts = new HashMap<String, Integer>();

	public static Map<String, Integer> getBrakeSetParts() throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = BrakeSet.class.getDeclaredFields();
		for (Field f : fields) {
			if(f.getType().toString().equals("int"))
			brakeSetParts.put(f.getName(), f.getInt(f));
		}
		return brakeSetParts;
	}

	public static final int getBrakePaddles() {
		return brakePaddles;
	}

	public static final int getBrakeCables() {
		return brakeCables;
	}

	public static final int getLevers() {
		return levers;
	}

	public static final int getBrakeShoes() {
		return brakeShoes;
	}

	public static boolean checkAvailablility(){
		boolean flag = false;
		for (String key : brakeSetParts.keySet()) {
			if (Stock.currentStock.get(key) - brakeSetParts.get(key)* Generate_BoM.brakeSetsFor1 >= 0) {
				flag = true;
			} else
				return false;
		}
		return flag;
	}
	public static void manufactureBrakeSet() {
		for (String key : brakeSetParts.keySet()) {
			Stock.currentStock.put(key, Stock.currentStock.get(key)-brakeSetParts.get(key));
		}
	}
}

package com.study.algorythm;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Bicycle {
	private static final int seats = 1;
	private static final int frames = 1;
	private static final int handlebars = 1;
	private static final int wheels = 2;
	private static final int tires = 2;
	private static final int chains = 1;
	private static final int crankSet = 1;
	private static final int paddles = 2;

	static Map<String, Integer> bicycleParts = new HashMap<String, Integer>();

	public static final int getSeats() {
		return seats;
	}

	public static final int getFrames() {
		return frames;
	}

	public static final int getHandlebars() {
		return handlebars;
	}

	public static final int getWheels() {
		return wheels;
	}

	public static final int getTires() {
		return tires;
	}

	public static final int getChains() {
		return chains;
	}

	public static final int getCrankset() {
		return crankSet;
	}

	public static final int getPaddles() {
		return paddles;
	}

	public static Map<String, Integer> getBicycleParts() throws IllegalArgumentException, IllegalAccessException {

		Field[] fields = Bicycle.class.getDeclaredFields();
		for (Field f : fields) {
			if (f.getType().toString().equals("int"))
				bicycleParts.put(f.getName(), f.getInt(f));
		}
		return bicycleParts;
	}

	public static boolean checkAvailablility() {
		boolean flag = false;
		for (String key : bicycleParts.keySet()) {
			if (Stock.currentStock.get(key) - bicycleParts.get(key) >= 0) {
				flag = true;
			} else
				return false;
		}
		return flag;
	}

	public static boolean manufactureBicycle() {
		boolean flag1 = Bicycle.checkAvailablility();
		boolean flag2 = BrakeSet.checkAvailablility();
		boolean flag3 = Stock.bicyclesManufactured < Generate_BoM.bicycles;
		if (flag1 == true && flag2 == true & flag3 == true) {
			for (String key : bicycleParts.keySet()) {
				Stock.currentStock.put(key, Stock.currentStock.get(key) - bicycleParts.get(key));
			}
			for(int i = 0;i<Generate_BoM.brakeSetsFor1;i++)
			BrakeSet.manufactureBrakeSet();
			Stock.bicyclesManufactured++;
		} else
			return false;
		return true;
	}
}

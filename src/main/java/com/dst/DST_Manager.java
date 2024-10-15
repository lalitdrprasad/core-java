package com.dst;

import java.sql.Time;
import java.time.LocalDateTime;

public class DST_Manager {

	static Time getExpiry() {

		@SuppressWarnings("deprecation")
		Time time = new Time(22, 0, 0);
		/*
		 * This time need to be taken as input or to be read from XML.
		 */
		return time;
	}

	@SuppressWarnings("deprecation")
	static void enableDST() {

		Time time = getExpiry();
		int hour = time.getHours();
		time.setHours(hour + 1);

		System.out.println("DST Enabled - Current Expiry Time : " + time);
		/*
		 * This time need to be given as output or to be written into XML.
		 */
	}

	@SuppressWarnings("deprecation")
	static void disableDST() {
		
		Time time = getExpiry();
		int hour = time.getHours();
		time.setHours(hour - 1);

		System.out.println("DST Disabled - Current Expiry Time : " + time);
		/*
		 * This time need to be given as output or to be written into XML.
		 */
	}

	public static void main(String[] args) {

		LocalDateTime date = LocalDateTime.now();

		/*
		 * Here we are passing current month to the switch and according to our need
		 * we'll enable/disable DST.
		 */
		switch (date.getMonthValue()) {

			case 1: disableDST(); break;
			case 2: disableDST(); break;
			case 3: disableDST(); break;
			case 10: disableDST(); break;
			case 11: disableDST(); break;
			case 12: disableDST(); break;
			
			case 4: enableDST(); break;
			case 5: enableDST(); break;
			case 6: enableDST(); break;
			case 7: enableDST(); break;
			case 8: enableDST(); break;
			case 9: enableDST(); break;
		}

	}
}

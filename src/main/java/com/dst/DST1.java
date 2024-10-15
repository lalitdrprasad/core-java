package com.dst;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DST1 {

	static void enableDST(LocalDateTime date, int hour, int minut) {
		
		
		int year = date.getYear();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		
		
		LocalDateTime localDateTime = LocalDateTime.of(year, Month.of(month), day, hour, minut);
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println("Spring forward");
        ZonedDateTime jumpOneHour = zonedDateTime.plus(1, ChronoUnit.HOURS);
       // ZonedDateTime jumpOneHour = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime);
        //System.out.println(zonedDateTime.toInstant());
        System.out.println(jumpOneHour);
       // System.out.println(jumpOneHour.toInstant());
       System.out.println(Duration.between(zonedDateTime, jumpOneHour));
	}

	static void disableDST(LocalDateTime date, int hour, int minut) {
		
		int year = date.getYear();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		
		
		LocalDateTime localDateTime = LocalDateTime.of(year, Month.of(month), day, hour, minut);        
		ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		System.out.println("fall backward");
   
        ZonedDateTime fallOneHour = zonedDateTime.plusHours(0);
        System.out.println(zonedDateTime);
       // System.out.println(zonedDateTime.toInstant());
        System.out.println(fallOneHour);
        //System.out.println(fallOneHour.toInstant());
        System.out.println(Duration.between(zonedDateTime, fallOneHour));
	}

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		
		
		int hour = 1;
		int minut = 30;
		
		System.out.println(date.getMonthValue());
		switch (date.getMonthValue()) {

			case 1: disableDST(date, hour, minut); break;
			case 2: disableDST(date, hour, minut); break;
			case 3: disableDST(date, hour, minut); break;
			case 10: disableDST(date, hour, minut); break;
			case 11: disableDST(date, hour, minut); break;
			case 12: disableDST(date, hour, minut); break;
			
			case 4: enableDST(date, hour, minut); break;
			case 5: enableDST(date, hour, minut); break;
			case 6: enableDST(date, hour, minut); break;
			case 7: enableDST(date, hour, minut); break;
			case 8: enableDST(date, hour, minut); break;
			case 9: enableDST(date, hour, minut); break;

		}
	}
}

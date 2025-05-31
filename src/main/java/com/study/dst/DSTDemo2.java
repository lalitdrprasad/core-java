package com.study.dst;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DSTDemo2 {
	public static void main(String[] args) {

		LocalDateTime localDateTime = LocalDateTime.of(2021, Month.MARCH, 12, 1, 30);
		ZoneId zoneId = ZoneId.of("America/New_York");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		System.out.println("Spring forward");
		ZonedDateTime jumpOneHour = zonedDateTime.plus(1, ChronoUnit.HOURS);
		// ZonedDateTime jumpOneHour = zonedDateTime.plusHours(1);
		System.out.println(zonedDateTime);
		// System.out.println(zonedDateTime.toInstant());
		System.out.println(jumpOneHour);
		// System.out.println(jumpOneHour.toInstant());
		System.out.println(Duration.between(zonedDateTime, jumpOneHour));

		System.out.println("fall backward");
		localDateTime = LocalDateTime.of(2021, Month.NOVEMBER, 5, 1, 30);
		zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		ZonedDateTime fallOneHour = zonedDateTime.plusHours(0);
		System.out.println(zonedDateTime);
		// System.out.println(zonedDateTime.toInstant());
		System.out.println(fallOneHour);
		// System.out.println(fallOneHour.toInstant());
		System.out.println(Duration.between(zonedDateTime, fallOneHour));

		System.out.println();
		System.out.println(ZonedDateTime.now());
	}

}

package chapter12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class DateTimeDemo {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2016, 12, 18);
		date1 = LocalDate.now();
//		System.out.println(date1);
//		System.out.println(date1.isLeapYear());
		
		LocalTime time1 = LocalTime.of(13, 20, 32);
//		System.out.println(time1);
		time1 = LocalTime.now();
//		System.out.println(time1);
		
		LocalDateTime dateTime1 = LocalDateTime.of(2016, 12, 18, 13, 24, 55);
		LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);
		LocalDateTime dateTime3 = LocalDateTime.now();
//		System.out.println(dateTime1);
//		System.out.println(dateTime2);
//		System.out.println(dateTime3);
		date1 = dateTime1.toLocalDate();
		time1 = dateTime1.toLocalTime();
//		System.out.println(date1);
//		System.out.println(time1);
		
		date1 = LocalDate.parse("2016-12-18");
		time1 = LocalTime.parse("13:02:44");
		dateTime1 = LocalDateTime.parse("2016-12-18T13:24:55");
//		System.out.println(date1);
//		System.out.println(time1);
//		System.out.println(dateTime1);
		
		System.out.println(date1.get(ChronoField.YEAR));
		System.out.println(date1.get(ChronoField.MONTH_OF_YEAR));
		System.out.println(date1.get(ChronoField.DAY_OF_MONTH));
		System.out.println(time1.get(ChronoField.HOUR_OF_AMPM));
		System.out.println(time1.get(ChronoField.HOUR_OF_DAY));
		System.out.println(time1.get(ChronoField.MINUTE_OF_HOUR));
		System.out.println(time1.get(ChronoField.SECOND_OF_MINUTE));
		System.out.println(dateTime1.get(ChronoField.YEAR));
		System.out.println(dateTime1.get(ChronoField.HOUR_OF_DAY));
	}

}

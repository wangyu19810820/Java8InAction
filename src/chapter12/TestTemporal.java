package chapter12;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TestTemporal {

	public static void main(String[] args) {
		testWithPlusMinus();
	}

	public static void testWithMethod() {
		LocalDate date = LocalDate.of(2014, 3, 18);
		// withYear设成2016，with设成5月20日
		date = date.withYear(2016);
		date = date.with(ChronoField.MONTH_OF_YEAR, 5);
		date = date.with(ChronoField.DAY_OF_MONTH, 20);
		System.out.println(date);
		
		LocalTime time = LocalTime.of(10, 30, 33);
		System.out.println(time);
		time = time.withHour(5);
		time = time.with(ChronoField.MINUTE_OF_HOUR, 20);
		time = time.with(ChronoField.SECOND_OF_MINUTE, 40);
		System.out.println(time);
	}
	
	public static void testWithPlusMinus() {
		LocalDate date = LocalDate.now();
		LocalDate date1 = date.plusWeeks(1);
		LocalDate date2 = date.plus(Period.ofWeeks(1));
		LocalDate date3 = date.plus(1, ChronoUnit.WEEKS);
		System.out.println(date1 + " " + date2 + " " + date3);
		
		LocalTime time = LocalTime.of(1, 10);
		LocalTime time1 = time.minusMinutes(20);
		LocalTime time2 = time.minus(Duration.of(20, ChronoUnit.MINUTES));
		LocalTime time3 = time.minus(20, ChronoUnit.MINUTES);
		System.out.println(time1 + " " + time2 + " " + time3);
		
		System.out.println(time.isSupported(ChronoUnit.DAYS));
		System.out.println(time1.until(time, ChronoUnit.MINUTES));
	}
}

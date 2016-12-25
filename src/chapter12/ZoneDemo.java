package chapter12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ZoneDemo {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		ZoneId z = ZoneId.systemDefault();
		System.out.println(z);
		ZoneId z1 = ZoneId.of("+7");
		System.out.println(z1);
		
		LocalDate date = LocalDate.now();
		System.out.println(date);
		ZonedDateTime zdt = date.atStartOfDay(z);
		ZonedDateTime zdt1 = date.atStartOfDay(z1);
		
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zdt2 = dateTime.atZone(z);
		
		System.out.println(zdt);
		System.out.println(zdt2);
		
		ZoneOffset shanghaiOffset = ZoneOffset.of("+08:00");
		OffsetDateTime dateTimeChina = OffsetDateTime.of(dateTime, shanghaiOffset);
		System.out.println(dateTimeChina);
		
	}
}

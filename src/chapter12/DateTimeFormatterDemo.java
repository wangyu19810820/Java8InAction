package chapter12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.HashMap;

public class DateTimeFormatterDemo {

	public static void main(String[] args) {
		test4();
	}
	
	public static void test1() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE;
		DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String s1 = date.format(df1);
		String s2 = df1.format(date);
		System.out.println(s1 + " " + s2);
		
		TemporalAccessor a1 = df.parse("2016-12-25");
		System.out.println(LocalDate.from(a1));
		LocalDate d1 = LocalDate.parse("2016-12-25", df);
		System.out.println(d1);
		
		System.out.println(LocalDate.parse("2016/12/25", df1));
	}
	
	public static void test2() {
		DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_TIME;
		String s1 = LocalTime.of(13, 11, 50).format(df);
		System.out.println(s1);
		
		LocalTime t1 = LocalTime.parse("12:30:50", df);
		LocalTime t2 = LocalTime.from(df.parse("12:30:50"));
		System.out.println(t1);
		System.out.println(t2);
	}
	
	public static void test3() {
		DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String s1 = LocalDateTime.now().format(df);
		System.out.println(s1);
		
		LocalDateTime dt1 = LocalDateTime.parse("2016-12-25T12:34:30", df);
		System.out.println(dt1);
	}
	
	public static void test4() {
		HashMap<Long, String> map = new HashMap<>();
		map.put(1L, "һ");
		map.put(2L, "��");
		map.put(3L, "��");
		map.put(4L, "��");
		map.put(5L, "��");
		map.put(6L, "��");
		map.put(7L, "��");
		map.put(8L, "��");
		map.put(9L, "��");
		map.put(10L, "ʮ");
		map.put(11L, "ʮһ");
		map.put(12L, "ʮ��");
		DateTimeFormatter df = new DateTimeFormatterBuilder()
				.appendText(ChronoField.YEAR)
				.appendText(ChronoField.MONTH_OF_YEAR, map)
				.appendText(ChronoField.DAY_OF_MONTH)
				.toFormatter();
		System.out.println(LocalDate.now().format(df));
		
	}
}

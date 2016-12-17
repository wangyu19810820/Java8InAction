package chapter12;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OldDateTime {

	public static void main(String[] args) {
		calendarDemo();
		dateTimeFormat();
	}

	public static void dateTimeFormat() {
		DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
		try {
			Date date = dtf.parse("2016-12-17 20:30:10 542");
			System.out.println(date);
			String s = dtf.format(new Date());
			System.out.println(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void calendarDemo() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println(cal.get(Calendar.YEAR) + " "
				+ (cal.get(Calendar.MONTH) + 1) + " "
				+ cal.get(Calendar.DAY_OF_MONTH) + " "
				+ (cal.get(Calendar.AM_PM) == 0 ? "AM" : "PM") + " "
				+ cal.get(Calendar.HOUR_OF_DAY) + " "
				+ cal.get(Calendar.MINUTE) + " "
				+ cal.get(Calendar.SECOND) + " ");
		
		GregorianCalendar gre = new GregorianCalendar(2016, 11, 17, 20, 30, 0);
		System.out.println(gre.get(Calendar.YEAR) + " "
				+ (gre.get(Calendar.MONTH) + 1) + " "
				+ gre.get(Calendar.DAY_OF_MONTH) + " "
				+ (gre.get(Calendar.AM_PM) == 0 ? "AM" : "PM") + " "
				+ gre.get(Calendar.HOUR_OF_DAY) + " "
				+ gre.get(Calendar.MINUTE) + " "
				+ gre.get(Calendar.SECOND) + " ");
		
	}
}

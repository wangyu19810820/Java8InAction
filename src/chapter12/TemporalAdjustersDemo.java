package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersDemo {
	          
	public static void main(String[] args) {
		testTemporalAdjust();
	}
	
	public static void testTemporalAdjust() {
		LocalDate d1 = LocalDate.of(2016, 12, 24);
		LocalDate d2 = d1.with(new TemporalAdjuster(){
			public Temporal adjustInto(Temporal temporal) {
				int dayOfWeek = temporal.get(ChronoField.DAY_OF_WEEK);
				if (dayOfWeek == 5 || dayOfWeek == 6) {
					return temporal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
				}
				return temporal.plus(Period.ofDays(1));
			}
		});
		System.out.println(d2);
		
		LocalDate d3 = d1.with(d -> {
			int dayOfWeek = d.get(ChronoField.DAY_OF_WEEK);
			if (dayOfWeek == 6 || dayOfWeek == 7) {
				return d.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			}
			return d.plus(Period.ofDays(1));
		});
		System.out.println(d3);
	}
	
	public static void testTemporalAdjusters() {
		// 2016,12�����һ��������
		LocalDate d1 = LocalDate.of(2016, 12, 24);
		TemporalAdjuster a1 = TemporalAdjusters.dayOfWeekInMonth(-1, DayOfWeek.SUNDAY);
		System.out.println(d1.with(a1));
		
		// 2016��12�µ�һ�죬���һ��
		TemporalAdjuster a2 = TemporalAdjusters.firstDayOfMonth();
		TemporalAdjuster a3 = TemporalAdjusters.lastDayOfMonth();
		System.out.println(d1.with(a2));
		System.out.println(a3.adjustInto(d1));
		
		// 2016��12�£����µĵ�һ��
		TemporalAdjuster a4 = TemporalAdjusters.firstDayOfNextMonth();
		System.out.println(a4.adjustInto(d1));
		
		// 2016��12�£��ڶ����һ��
		TemporalAdjuster a5 = TemporalAdjusters.firstDayOfNextYear();
		System.out.println(d1.with(a5));
		
		// 2016���һ��,���һ��
		TemporalAdjuster a6 = TemporalAdjusters.firstDayOfYear();
		System.out.println(d1.with(a6));
		TemporalAdjuster a7 = TemporalAdjusters.lastDayOfYear();
		System.out.println(d1.with(a7));
		
		// 2016��12�£���һ��������,���һ��������
		TemporalAdjuster a8 = TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY);
		System.out.println(a8.adjustInto(d1));
		TemporalAdjuster a9 = TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY);
		System.out.println(d1.with(a9));
		
		// 2016��12��24�գ�֮�������
		TemporalAdjuster a10 = TemporalAdjusters.next(DayOfWeek.SATURDAY);
		System.out.println(d1.with(a10));
		
		// 2016��12��24�գ������������Ļ����ǽ��죬������֮�������
		TemporalAdjuster a11 = TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY);
		System.out.println(d1.with(a11));
		
		// 2016��12��24�գ�֮ǰ������
		// 2016��12��24�գ������������Ļ����ǽ��죬������֮ǰ������
		TemporalAdjuster a12 = TemporalAdjusters.previous(DayOfWeek.SATURDAY);
		TemporalAdjuster a13 = TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY);
		System.out.println(d1.with(a12));
		System.out.println(d1.with(a13));
		
		// 2016��12�µĵڶ���
		TemporalAdjuster a14 = TemporalAdjusters.ofDateAdjuster(d -> {
			return d.with(ChronoField.DAY_OF_MONTH, 2);
		});
		System.out.println(d1.with(a14));
	}

}

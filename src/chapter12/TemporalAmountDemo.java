package chapter12;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TemporalAmountDemo {

	public static void main(String[] args) {
		testMethod();
	}
	
	public static void testBasic() {
		Duration d1 = Duration.ofMinutes(3);
		System.out.println(d1.getUnits());
		System.out.println(d1.get(ChronoUnit.SECONDS));
		
		Period p1 = Period.of(1, 2, 3);
		System.out.println(p1.getUnits());
		Period p2 = Period.ofMonths(1);
		p2 = p1.multipliedBy(2);
		System.out.println(p1);
		System.out.println(p2);
	}
	
	public static void testTemporalAmount() {
		// TemporalAmount�����4��������addTo��get��getUnits��subtractFrom
		Duration d1 = Duration.ofMinutes(3);
		// ��ȡʱ��ζ����ڣ����õ�λ����
		System.out.println(d1.getUnits());
		// ��ȡ������
		System.out.println(d1.get(ChronoUnit.SECONDS));
		// ��ǰʱ��������Ӻ��ʱ��
		System.out.println(d1.addTo(LocalTime.now()));
		// ��ǰʱ��ǰ�����ӵ�ʱ��
		System.out.println(d1.subtractFrom(LocalTime.now()));
	}

	public static void testMethod() {
		// between, of, parse
		LocalDate date1 = LocalDate.of(2016, 3, 3);
		LocalDate date2 = LocalDate.of(2016, 3, 5);
		Period p1 = Period.between(date1, date2);
		System.out.println(p1);
		System.out.println(Period.of(0, 2, 32));
		System.out.println(Duration.parse("PT3H2M5S"));
		System.out.println(Period.parse("P3Y2M4D"));
		
		// isNegative, isZero
		LocalDate date3 = LocalDate.of(2016, 12, 23);
		LocalDate date4 = LocalDate.of(2016, 12, 25);
		Period p2 = Period.between(date3, date4);
		System.out.println(p2.isNegative());
		System.out.println(p2);
		System.out.println(p2.isZero());
		
		// plus, minus, negated
		Duration d1 = Duration.of(1, ChronoUnit.DAYS);
		Duration d2 = Duration.parse("P2D");
		Duration d3 = d2.plus(d1);
		System.out.println(d3);
		d3 = d2.minus(d1);
		System.out.println(d3);
		d3 = d1.negated();
		System.out.println(d3);
		
		// ��֤Period�Ƿ�֧��ʱ���룬���룬Duration�Ƿ�֧��������
		Period p3 = Period.parse("P2M");
		System.out.println(p3);
		Duration d4 = Duration.parse("P3DT2H3M4S");
		System.out.println(d4);
	}
}

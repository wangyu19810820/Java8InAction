package chapter03;

import java.util.function.DoubleFunction;

public class IntegralDemo {

	public static double f(double d) {
		return d + 10;
	}
	
	public static double area(DoubleFunction<Double> df, double x, double y) {
		return 0.5 * (y - x) * (df.apply(x) + df.apply(y));
	}
	
	public static void main(String[] args) {
		System.out.println(area(IntegralDemo::f, 3, 7));
		System.out.println(area((double d) -> d + 10, 3, 7));
	}
}

package chapter13;

import java.util.stream.IntStream;

public class FactorialDemo {

	public static void main(String[] args) {
//		int result = IntStream.range(1, 5).reduce(1, (i1, i2) -> i1 * i2);
//		System.out.println(result);
		
		int result = calc(1, 5);
		System.out.println(result);
	}
	
	public static int calc(int i, int b) {
		if (b == 1) return i;
		return calc(i * b, b - 1);
	}
}

package chapter07;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestSum {

	static class Accumulator {
		long total = 0;
		public void add(long i) {
			total += i;
		}
	}
	
	public static long sumByWrongParallelStream(long n) {
		Accumulator a = new Accumulator();
		LongStream.range(1, n).parallel().forEach(a::add);
		return a.total;
	}
	
	public static long sumByObjectStream(long n) {
		return Stream.iterate(1L, i -> i + 1)
					 .limit(n - 1)
					 .parallel()
					 .reduce(0L, Long::sum);
	}
	
	public static long sumByStream(long n) {
		return LongStream.range(1, n).parallel().reduce(0, Long::sum);
	}
	
	public static long sumByFor(long n) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		final long v = 100_000_000L;
//		long t1 = TestFuncTime.measureSumperf(TestSum::sumByStream, v);
		long t2 = TestFuncTime.measureSumperf(TestSum::sumByFor, v);
//		long t3 = TestFuncTime.measureSumperf(TestSum::sumByObjectStream, v);
		long t4 = TestFuncTime.measureSumperf(TestSum::sumByWrongParallelStream, v);
//		System.out.println("t1=" + t1);
		System.out.println("t2=" + t2);
//		System.out.println("t3=" + t3);
		System.out.println("t4=" + t4);
	}
}

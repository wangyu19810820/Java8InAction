package chapter07;

import java.util.function.Function;

public class TestFuncTime {

	public static long measureSumperf(Function<Long, Long> addr, long n) {
		long minTime = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long sTime = System.currentTimeMillis();
			Long v = addr.apply(n);
			long dTime = System.currentTimeMillis() - sTime;
			System.out.println("result" + v);
			if (dTime < minTime) minTime = dTime;
		}
		return minTime;
	}
}

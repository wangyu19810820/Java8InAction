package chapter07;
//fork, join

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	long[] number;
	int start;
	int end;
	private static final Long ENDFORK = 10_000L;
	
	public ForkJoinSumCalculator(long[] number, int start, int end) {
		this.number = number;
		this.start = start;
		this.end = end;
	}
	
	public Long compute() {
		if (end - start < ENDFORK) {
			return computerDirector();
		}
		
		int middle = (start + end) / 2;
		ForkJoinSumCalculator left = new ForkJoinSumCalculator(number, start, middle);
		left.fork();
		ForkJoinSumCalculator right = new ForkJoinSumCalculator(number, middle + 1, end);
		long rightValue = right.compute();
		long leftValue = left.join();
		
		return leftValue + rightValue;
	}
	
	public Long computerDirector() {
		long sum = 0;
		for (int i = start; i <= end; i++) {
			sum += number[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		long[] num = new long[100_000_000];
		long sum = 0;
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
			sum += num[i];
		}
		System.out.println(sum);
		
		long minTime = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long sTime = System.currentTimeMillis();
			test(num);
			long dTime = System.currentTimeMillis() - sTime;
			if (dTime < minTime) minTime = dTime;
		}
		System.out.println("minTime:" + minTime);
	}
	
	public static void test(long[] num) {
		ForkJoinSumCalculator c = new ForkJoinSumCalculator(num, 0, num.length - 1);
		long l = c.compute();
	}

}

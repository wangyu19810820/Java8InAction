package chapter07;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SumSpliterator implements Spliterator<Long> {

	long[] num;
	int index;
	
	public SumSpliterator(long[] num) {
		this.num = num;
		index = 0;
	}
	
	@Override
	public boolean tryAdvance(Consumer<? super Long> action) {
		action.accept(num[index++]);
		return index < num.length;
	}

	@Override
	public Spliterator<Long> trySplit() {
		if (num.length - index < 10_000) return null;
		int middle = (num.length + index) / 2;
		
		SumSpliterator s = new SumSpliterator(Arrays.copyOfRange(num, index, middle));
		index = middle;
		return s;
	}

	@Override
	public long estimateSize() {
		return num.length - index;
	}

	@Override
	public int characteristics() {
		return SIZED + SUBSIZED + NONNULL + IMMUTABLE;
	}

	public static void main(String[] args) {
		long[] num = new long[10_000_000];
		long sum = 0;
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
			sum += num[i];
		}
		System.out.println(sum);

		long sTime = System.currentTimeMillis();
		long r = sum(num);
		long dTime = System.currentTimeMillis() - sTime;
		System.out.println("time" + dTime);
		System.out.println(r);
	}
	
	public static long sum(long[] num) {
		SumSpliterator s = new SumSpliterator(num);
		Stream<Long> stream = StreamSupport.stream(s, true);
		return stream.collect(Collectors.summingLong(l->l));
	}
}

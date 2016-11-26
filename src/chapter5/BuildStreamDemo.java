package chapter5;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.function.Supplier;

public class BuildStreamDemo {

	public static void main(String[] args) {
//		buildFromValue();
//		buildFromArray();
//		buildFromIterator();
//		buildFromGenerator();
//		faboIterate();
		faboGenerate();
	}

	public static void buildFromValue() {
		Stream<String> stream = Stream.of("aa", "bb", "cc");
		stream.forEach(System.out::println);
	}
	
	public static void buildFromArray() {
		String[] array = new String[]{"a1", "b1", "c1"};
		Stream<String> stream = Arrays.stream(array);
		stream.forEach(System.out::println);
	}
	
	public static void buildFromIterator() {
		Stream<String> stream = Stream.iterate("0", (String str)->{
			int i = Integer.parseInt(str);
			return i + 1 + "";
		}).limit(10);
		stream.forEach(System.out::println);
	}
	
	public static void buildFromGenerator() {
		Stream<String> stream = Stream.generate(new Supplier<String>(){
			private int i = 0;
			public String get() {
				return (i++) + "";
			}
		}).limit(10);
		stream.forEach(System.out::println);
	}
	
	public static void faboIterate() {
		IntStream stream = Stream.iterate(new int[]{0, 1}, arr -> {
			return new int[]{arr[1], arr[0] + arr[1]};
		}).limit(20)
		  .mapToInt(arr -> arr[0]);
		stream.forEach(System.out::println);
	}
	
	public static void faboGenerate() {
		IntStream stream = IntStream.generate(new IntSupplier(){
			private int first = 0;
			private int second = 1;
			
			@Override
			public int getAsInt() {
				int i = first;
				int j = second;
				first = second;
				second = i + j; 
				return i;
			}
		}).limit(20);
		stream.forEach(System.out::println);
	}
}

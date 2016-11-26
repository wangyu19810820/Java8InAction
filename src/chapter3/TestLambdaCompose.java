package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import chapter2.Apple;

public class TestLambdaCompose {

	public static void main(String[] args) {
		List<Apple> list = new ArrayList<Apple>();
		list.add(new Apple("apple1", "red", 150));
		list.add(new Apple("apple2", "red", 300));
		list.add(new Apple("apple3", "green", 150));
		list.add(new Apple("apple4", "green", 250));
		
//		list.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor));
//		list.forEach(System.out::println);

//		Predicate<Apple> haveyApple = apple->apple.getWeight()>200;
//		Stream<Apple> stream = list.stream().filter(haveyApple
//				.and(apple->apple.getColor().equals("red"))
//				.or(apple->apple.getColor().equals("green")));
//		stream.forEach(System.out::println);
		
		Function<Apple, Integer> addWeight = apple->apple.getWeight() + 100;
//		list.forEach(apple->apple.setWeight(addWeight.andThen((Integer i)->{
//			return i * 2;
//		}).apply(apple)));
		list.forEach(apple->apple.setWeight(addWeight.compose((Apple apple1)->{
			apple1.setWeight(apple1.getWeight() * 2);
			return apple1;
		}).apply(apple)));
		list.forEach(System.out::println);
		
//		Function<Integer, Integer> f1 = i -> i + 1;
//		Function<Integer, Integer> f2 = i -> i * 2;
//		int result = f1.andThen(f2).apply(2);
//		int result1 = f1.compose(f2).apply(2);
//		System.out.println(result + " " + result1);
		
	}

}

package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import chapter4.Dish;
import chapter4.TestDish;

public class SteamDemo {

	public static void main(String[] args) {
		List<Dish> menu = TestDish.getDishList();
		
//		List<Dish> list = menu.stream().filter(Dish::isVegentarian)
//					 				   .collect(Collectors.toList());
//		list.forEach(System.out::println);
		
//		List<String> strList = menu.stream().map(dish -> dish.getType().name())
//											.distinct()
//											.collect(Collectors.toList());
//		strList.forEach(System.out::println);
		
//		menu.stream().map(dish -> dish.getType().name())
//						.collect(Collectors.toSet())
//						.forEach(System.out::println);

//		List<Dish> list = menu.stream().filter(dish -> dish.getCalories() > 300)
//									   .limit(3)
//									   .collect(Collectors.toList());
//		list.forEach(System.out::println);
//		System.out.println();
//		List<Dish> list1 = menu.stream().filter(dish -> dish.getCalories() > 300)
//									    .skip(3)
//									    .collect(Collectors.toList());
//		list1.forEach(System.out::println);
		
//		List<String> nameList = Arrays.asList("Java 8", "lambda", "in", "Action");
//		List<Integer> intList = nameList.stream().map(String::length)
//												 .collect(Collectors.toList());
//		intList.forEach(System.out::println);
		
//		boolean flag = menu.stream().anyMatch(Dish::isVegentarian);
//		if (flag) {
//			System.out.println("包含蔬菜");
//		} else {
//			System.out.println("不包含蔬菜");
//		}
		
//		boolean flag = menu.stream().allMatch(dish->dish.getCalories() < 800);
//		if (flag) {
//			System.out.println("都小于800卡路里");
//		} else {
//			System.out.println("有大于800卡路里的");
//		}
		
//		boolean flag = menu.stream().noneMatch(dish->dish.getCalories() >= 1000);
//		if (flag) {
//			System.out.println("没有大于等于1000卡路里");
//		} else {
//			System.out.println("有大于等于1000卡路里");
//		}
		
//		Optional<Dish> opt = menu.parallelStream().filter(Dish::isVegentarian)
//										  		  .findAny();
//		opt.ifPresent(dish -> System.out.println(dish));
//		
//		Optional<Dish> opt1 = menu.parallelStream().filter(Dish::isVegentarian)
//										   		   .findFirst();
//		opt1.ifPresent(dish -> System.out.println(dish));
		
//		Optional<Dish> opt = menu.stream().reduce((dish1, dish2) -> {
//			return new Dish("sum", false, dish1.getCalories() + dish2.getCalories(), Dish.Type.Other);
//		});
//		opt.ifPresent(System.out::println);
//		
//		Optional<Dish> opt1 = menu.stream().reduce((dish1, dish2) -> dish1.getCalories() > dish2.getCalories() ? dish1 : dish2);
//		opt1.ifPresent(System.out::println);
//		
//		Optional<Dish> opt2 = menu.stream().reduce((dish1, dish2) -> dish1.getCalories() < dish2.getCalories() ? dish1 : dish2);
//		opt2.ifPresent(System.out::println);
		
//		Optional<Integer> opt = menu.stream().map(d->1).reduce(Integer::sum);
//		System.out.println(opt.get());
		
		System.out.println(menu.stream().count());
		
//		testFlatMap();
//		testFlatMap1();
	}
	
	public static void testFlatMap1() {
		// 嵌套迭代两个流中的每一个元素，压扁成新的元素流
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(3, 4);
		
		list1.stream().map(i -> {
			// 返回int数组的流的流
			return list2.stream().map(j -> new int[]{i, j});
		}).forEach(stream -> stream.forEach((int[] intArr) -> {
//			System.out.println(intArr[0] + " " + intArr[1]);
		}));
		
//		List<int[]> result = list1.stream().flatMap(i -> {
//			// int数组的流的流,被压扁成int数组的流
//			return list2.stream().map(j -> new int[]{i, j});
//		}).filter(intArr->{
//			return (intArr[0] + intArr[1]) % 3 == 0;
//		}).collect(Collectors.toList());
		
		List<int[]> result = list1.stream().flatMap(i -> {
			// int数组的流的流,被压扁成int数组的流
			return list2.stream().filter(j -> (i + j) % 3 == 0)
								 .map(j -> new int[]{i, j});
		}).collect(Collectors.toList());

		result.forEach(intArr -> {
			for (int i : intArr) {
				System.out.print(i + " ");
			}
			System.out.println();
		});
	}
	
	public static void testFlatMap() {
		String[] wordsArray = {"Hello", "World"};
		List<String> wordsList = Arrays.asList(wordsArray);
		
//		Stream<String> stringStream = Arrays.stream(wordsArray);
//		stringStream.forEach(System.out::println);
		
		// 字符串流转换成字符串数组流，再转换成字符串数组列表
//		List<String[]> list = wordsList.stream().map(str -> str.split(""))
//						  					    .distinct()
//						  					    .collect(Collectors.toList());
//		for (String s : list.get(1)) {
//			System.out.println(s);
//		}
		
		// 字符串流转换成字符串流的流
		wordsList.stream().map(str->str.split(""))	// 字符串流转换成字符串数组流
						  .map(Arrays::stream)		// 字符串数组的流转换成字符串流的流
						  .distinct()
						  .forEach((Stream<String> stream) -> {
							  stream.forEach((String s)->System.out.print(s + " "));
							  System.out.println();
						  });
		
		// 字符串流转换成字符串流
		wordsList.stream().map(str->str.split(""))	// 字符串流转换成字符串数组流
						  .flatMap(Arrays::stream)	// 字符串数组流转换成字符串流
						  .distinct()
						  .forEach(s -> System.out.print(s + " "));
	}
}

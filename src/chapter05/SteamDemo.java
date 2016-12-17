package chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import chapter04.Dish;
import chapter04.TestDish;

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
//			System.out.println("�����߲�");
//		} else {
//			System.out.println("�������߲�");
//		}
		
//		boolean flag = menu.stream().allMatch(dish->dish.getCalories() < 800);
//		if (flag) {
//			System.out.println("��С��800��·��");
//		} else {
//			System.out.println("�д���800��·���");
//		}
		
//		boolean flag = menu.stream().noneMatch(dish->dish.getCalories() >= 1000);
//		if (flag) {
//			System.out.println("û�д��ڵ���1000��·��");
//		} else {
//			System.out.println("�д��ڵ���1000��·��");
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
		// Ƕ�׵����������е�ÿһ��Ԫ�أ�ѹ����µ�Ԫ����
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(3, 4);
		
		list1.stream().map(i -> {
			// ����int�����������
			return list2.stream().map(j -> new int[]{i, j});
		}).forEach(stream -> stream.forEach((int[] intArr) -> {
//			System.out.println(intArr[0] + " " + intArr[1]);
		}));
		
//		List<int[]> result = list1.stream().flatMap(i -> {
//			// int�����������,��ѹ���int�������
//			return list2.stream().map(j -> new int[]{i, j});
//		}).filter(intArr->{
//			return (intArr[0] + intArr[1]) % 3 == 0;
//		}).collect(Collectors.toList());
		
		List<int[]> result = list1.stream().flatMap(i -> {
			// int�����������,��ѹ���int�������
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
		
		// �ַ�����ת�����ַ�������������ת�����ַ��������б�
//		List<String[]> list = wordsList.stream().map(str -> str.split(""))
//						  					    .distinct()
//						  					    .collect(Collectors.toList());
//		for (String s : list.get(1)) {
//			System.out.println(s);
//		}
		
		// �ַ�����ת�����ַ���������
		wordsList.stream().map(str->str.split(""))	// �ַ�����ת�����ַ���������
						  .map(Arrays::stream)		// �ַ����������ת�����ַ���������
						  .distinct()
						  .forEach((Stream<String> stream) -> {
							  stream.forEach((String s)->System.out.print(s + " "));
							  System.out.println();
						  });
		
		// �ַ�����ת�����ַ�����
		wordsList.stream().map(str->str.split(""))	// �ַ�����ת�����ַ���������
						  .flatMap(Arrays::stream)	// �ַ���������ת�����ַ�����
						  .distinct()
						  .forEach(s -> System.out.print(s + " "));
	}
}

package chapter6;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import chapter4.Dish;
import chapter4.TestDish;

public class Test {

	public static void main(String[] args) {
		List<Dish> list = TestDish.getDishList();
//		Map<Dish.Type, List<Dish>> result = list.stream().collect(Collectors.groupingBy(Dish::getType));               
//		print(result);
		
//		Long count = list.stream().collect(Collectors.counting());
//		System.out.println(count);
		
//		IntSummaryStatistics dish = 
		list.stream().collect(
			Collectors.reducing(0.0, Dish::getCalories, (Double i, Double j)->{return i+j;})
		);
//		System.out.println(dish.getCalories());
		
		
//		double avg = list.stream().collect(Collectors.averagingDouble(Dish::getCalories));
//		System.out.println(avg);
//		
//		double sum = list.stream().collect(Collectors.summingDouble(Dish::getCalories));
//		System.out.println(sum);
//		
//		DoubleSummaryStatistics summary = list.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
//		System.out.println(summary);
		
		
	}
	
	public static void print(Map<?, List<Dish>> map) {
		for (Object o: map.keySet()) {
			System.out.println(o);
			for (Object l : map.get(o)) {
				System.out.println(l);
			}
			System.out.println();
		}
	}
}

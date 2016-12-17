package chapter06;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import chapter04.Dish;
import chapter04.TestDish;

public class Test {

	public static void main(String[] args) {
		List<Dish> list = TestDish.getDishList();
//		Map<Dish.Type, List<Dish>> result = list.stream().collect(Collectors.groupingBy(Dish::getType));               
//		print(result);
		
//		Long count = list.stream().collect(Collectors.counting());
//		System.out.println(count);
		
		list.stream().collect(
			Collectors.reducing(0.0, Dish::getCalories, Double::sum)
		);
//		System.out.println(dish.getCalories());
		Optional<Double> opt = list.stream().map(d->d.getCalories()).collect(
				Collectors.reducing(Double::sum)
		);
		System.out.println(opt.get());
		
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

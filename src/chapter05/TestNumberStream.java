package chapter05;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

import chapter04.Dish;
import chapter04.TestDish;

/**
 * π¥π…∂®¿Ì
 * @author Administrator
 *
 */
public class TestNumberStream {
	
	public static void main(String[] args) {
		List<Dish> menu = TestDish.getDishList();
		OptionalDouble avg = menu.stream().mapToDouble(Dish::getCalories)
										  .average();
		avg.ifPresent(System.out::println);
		
		IntStream.rangeClosed(1, 20).boxed()
				 .flatMap(i -> IntStream.rangeClosed(i, 20)
						 .filter(j -> Math.sqrt(i * i + j * j) % 1 == 0)
						 .mapToObj(j -> new int[]{i, j, (int)Math.sqrt(i * i + j * j)}))
				 .forEach(arr -> System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2]));
	}
}
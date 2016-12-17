package chapter04;

import java.util.ArrayList;
import java.util.List;

public class TestDish {

	public static void main(String[] args) {		
		Dish[] array = new Dish[] {
			new Dish("pork", false, 800, Dish.Type.Meat),
			new Dish("beef", false, 700, Dish.Type.Meat)
		};
		
		Object[] dishArray = (Object[]) array;
		
		for (Object o : dishArray) {
			System.out.println(o);
		}
	}

	public static List<Dish> getDishList() {
		List<Dish> list = new ArrayList<Dish>();
		list.add(new Dish("pork", false, 800, Dish.Type.Meat));
		list.add(new Dish("beef", false, 700, Dish.Type.Meat));
		list.add(new Dish("chicken", false, 400, Dish.Type.Meat));
		list.add(new Dish("french fries", true, 530, Dish.Type.Other));
		list.add(new Dish("rice", true, 350, Dish.Type.Other));
		list.add(new Dish("season fruit", true, 120, Dish.Type.Other));
		list.add(new Dish("pizza", true, 550, Dish.Type.Other));
		list.add(new Dish("prawns", false, 300, Dish.Type.Fish));
		list.add(new Dish("salmon", false, 450, Dish.Type.Fish));
//		for (int i = 0; i < 10000; i++) {
//			list.add(new Dish("veg", true, i, Dish.Type.Other));
//		}
		return list;
	}
}

package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleDemo {
	
	public static void main(String[] args) {
		List<Apple> list = new ArrayList<Apple>();
		list.add(new Apple("apple1", "red", 100));
		list.add(new Apple("apple2", "red", 300));
		list.add(new Apple("apple3", "green", 150));
		list.add(new Apple("apple4", "green", 250));
		List<Apple> result = filter(list, Apple::moreThan150);
		
		for(Apple apple :  result) {
			System.out.println(apple);
		}
		
		List<Orange> list1 = new ArrayList<Orange>();
		list1.add(new Orange("Orange1", 3));
		list1.add(new Orange("Orange2", 2));
		list1.add(new Orange("Orange3", 5));
		list1.add(new Orange("Orange4", 1));
		list1.add(new Orange("Orange5", 4));
		List<Orange> result1 = filter(list1, Orange::isGood);
		
		for(Orange orange : result1) {
			System.out.println(orange);
		}
	}
	
	public static <T extends Fruit> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<T>();
		for (T t : list) {
			if (p.test(t)) {
				result.add(t);
			}
		}
		return result;
	}
}



package chapter3;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import chapter2.Apple;

public class SortApple {

	public static void main(String[] args) {
		List<Apple> list = new ArrayList<Apple>();
		list.add(new Apple("apple1", "red", 100));
		list.add(new Apple("apple2", "red", 300));
		list.add(new Apple("apple3", "green", 150));
		list.add(new Apple("apple4", "green", 250));
		
		list.sort(new Comparator<Apple>(){
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight() - o2.getWeight();
			}
		});
		list.sort(comparing(apple->{return apple.getWeight();}));
		list.sort(comparing(Apple::getWeight));
		
		for(Apple apple : list) {
			System.out.println(apple);
		}
	}
}

package newapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsDemo {

	public static void main(String[] args) {
		testString();
	}
	
	public static void testString() {
		List<String> list = Arrays.asList("a", "b", "c");
		String s = String.join(",", list);
		System.out.println(s);
	}
	
	public static void testMath() {
//		long l = 100000000000000000L;
//		int i = (int)l;
//		System.out.println(i);
//		System.out.println(Math.toIntExact(l));
		int j = 2_000_000_000;
		System.out.println(j + j);
		System.out.println(Math.addExact(j, j));
	}
	
	public static void testArrays() {
		int[] arr = new int[10];
		Arrays.parallelSetAll(arr, i -> i + 1);
		Arrays.parallelPrefix(arr, (i, j) -> i * j);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void testList() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(4);
		list.replaceAll(i -> i + 10);
		System.out.println(list);
		Comparator<? super Integer> c = Comparator.naturalOrder();
		c = c.reversed();
		list.sort(c);
		System.out.println(list);
		list.removeIf(i -> i % 2 == 0);
		System.out.println(list);
	}
	
	public static void testMap() {
		Map<String, String> map = new HashMap<>();
		map.put("A", null);
		map.put("B", "2");
		System.out.println(map.getOrDefault("A", "0"));
		System.out.println(map.getOrDefault("B", "0"));
		System.out.println(map.getOrDefault("C", "0"));
		
		map.computeIfAbsent("A", s -> "10");
		map.computeIfAbsent("B", s -> "10");
		map.computeIfAbsent("C", s -> "10");
		
		System.out.println(map);
	}
}

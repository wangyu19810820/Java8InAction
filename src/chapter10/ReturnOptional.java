package chapter10;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ReturnOptional {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("a1", "aa");
		map.put("b1", "bb");
		Optional<String> opt1 = getMapValue(map, "c1");
		System.out.println(opt1.orElse("none"));
		Optional<String> opt2 = getMapValue(map, "a1");
		System.out.println(opt2.orElse("none"));
		
		Optional<Integer> opt3 = stringToInt("123");
		opt3.ifPresent(System.out::println);
		Optional<Integer> opt4 = stringToInt(null);
		opt4.ifPresent(System.out::println);
		Optional<Integer> opt5 = stringToInt("12a");
		opt5.ifPresent(System.out::println);
	}

	public static <K, V> Optional<V> getMapValue(Map<K, V>map, K key) {
		return Optional.ofNullable(map.get(key));
	}
	
	public static Optional<Integer> stringToInt(String s) {
		try {
			return Optional.ofNullable(Integer.parseInt(s));
		} catch (Exception e) {
			return Optional.empty();
		}
	}
}

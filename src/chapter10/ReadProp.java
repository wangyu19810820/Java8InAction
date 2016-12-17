package chapter10;

import java.util.Optional;
import java.util.Properties;

public class ReadProp {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("a", "-5");
		prop.put("b", "abc");
		prop.put("c", "3");
		
		System.out.println(readProp(prop, "a"));
		System.out.println(readProp(prop, "b"));
		System.out.println(readProp(prop, "c"));
	}

	public static int readProp(Properties prop, String key) {
		return Optional.ofNullable(prop.getProperty(key))
					   .flatMap(ReturnOptional::stringToInt)
					   .filter(i -> i >= 0)
					   .orElse(0);
	}
}

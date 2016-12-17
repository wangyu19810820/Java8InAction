package chapter03;

import java.util.function.Function;

public class Letter {
	
	public static String addHeader(String str) {
		return "this is header\n" + str;
	}
	
	public static String addFooter(String str) {
		return str + "\nthis is footer";
	}
	
	public static String checkSpell(String str) {
		return str.replaceAll("labda", "lambda");
	}
	
	public static void main(String[] args) {
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> letter = addHeader.andThen(Letter::checkSpell)
				.andThen(Letter::addFooter);
		String content = "hello labda world";
		String result = letter.apply(content);
		System.out.println(result);
	}
}
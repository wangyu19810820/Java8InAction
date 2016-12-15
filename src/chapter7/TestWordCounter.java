package chapter7;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TestWordCounter {

	static class WordCounterSpliterator implements Spliterator<Character> {

		private final String string;
		private int currentChar = 0;
		
		public WordCounterSpliterator(String string) {
			this.string = string;
		}
		
		@Override
		public boolean tryAdvance(Consumer<? super Character> action) {
//			System.out.println(currentChar);
			action.accept(string.charAt(currentChar++));
			return currentChar < string.length();
		}

		@Override
		public Spliterator<Character> trySplit() {
			if (currentChar > string.length() - 10) {
				return null;
			}
			int middle = (string.length() + currentChar) / 2;
			for (int i = middle; i < string.length(); i++) {
				if (Character.isWhitespace(string.charAt(i))) {
					String subStr = string.substring(currentChar, i);
					currentChar = i;
					Spliterator<Character> s = new WordCounterSpliterator(subStr);
//					System.out.println(subStr);
//					System.out.println(string.substring(currentChar));
					return s;
				}
			}
			return null;
		}

		@Override
		public long estimateSize() {
			return string.length() - currentChar;
		}

		@Override
		public int characteristics() {
			return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
		}
		
	}

	public static int count2(String s) {
		Spliterator<Character> s1 = new WordCounterSpliterator(s);
		Stream<Character> stream = StreamSupport.stream(s1, true);
		WordCounter c = stream.reduce(new WordCounter(0, true),
				WordCounter::accumulator,
				WordCounter::combine);
		return c.getCount();
	}

	public static int count1(String s) {
		Stream<Character> stream = IntStream.range(0, s.length())
											.mapToObj(s::charAt)
//											.parallel()
											;
		// NOT SUPPORT parallel, because one word will splite to many
		WordCounter c = stream.reduce(new WordCounter(0, true),
				WordCounter::accumulator,
				WordCounter::combine);
		return c.getCount();
	}
	
	public static int count(String s) {
		int count = 0;
		boolean isWhiteSpace = true;
		// previous is whitespace, this is not whitespace, count+1
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				isWhiteSpace = true;
			} else {
				if (isWhiteSpace) {
					count++;
				}
				isWhiteSpace = false;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		final String sentence = " Nel   mezzo del cammin di nostra vita 	" +
				"mi ritroval in una selva oscura" + 
				" che la dritta via era smarrita ";
		int count = count(sentence);
		System.out.println(sentence.length());
		int count2 = count2(sentence);
		System.out.println(count2);
	}
}

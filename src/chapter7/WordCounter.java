package chapter7;

public class WordCounter {
	private final int counter;
	private final boolean lastSpace;
	
	public WordCounter(int counter, boolean lastSpace) {
		this.counter = counter;
		this.lastSpace = lastSpace;
	}
	
	public WordCounter accumulator(char c) {
		if (Character.isWhitespace(c)) {
			return new WordCounter(this.counter, true);
		} else {
			if (this.lastSpace) {
				return new WordCounter(this.counter + 1, false);
			} else {
				return this;
			}
		}
	}
	
	public WordCounter combine(WordCounter c1) {
		return new WordCounter(c1.counter + this.counter, c1.lastSpace);
	}
	
	public int getCount() {
		return counter;
	}
}
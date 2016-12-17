package chapter09;

public interface B {

	default void hello() {
		System.out.println("hello from B");
	}
}

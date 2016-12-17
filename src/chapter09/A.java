package chapter09;

public interface A {

	default void hello() {
		System.out.println("hello from A");
	}
}

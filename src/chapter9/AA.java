package chapter9;

public interface AA extends A {

	default void hello() {
		System.out.println("hello from AA");
	}
}

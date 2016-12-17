package chapter9;

public interface B {

	default void hello() {
		System.out.println("hello from B");
	}
}

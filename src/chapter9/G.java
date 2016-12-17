package chapter9;

public class G implements A, B {

	@Override
	public void hello() {
		A.super.hello();
	}

	public static void main(String[] args) {
		new G().hello();
	}
}

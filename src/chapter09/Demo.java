package chapter09;

public class Demo implements DemoInterface {

	@Override
	public void a() {
		System.out.println("Hello World");
	}
	
	public static void main(String[] args) {
		new Demo().a();
	}

}

package chapter13;

public class TrainDemo {

	public static void main(String[] args) {
		Train c = new Train(5, null);
		Train b = new Train(15, null);
		Train a = new Train(25, b);

		Train d = concat1(a, c);
		print(a);
		System.out.println("+++++++++++++++++++++");
		print(d);
	}
	
	public static Train concat1(Train t1, Train t2) {
		if (t1 == null)
			return t2;
		else
			return new Train(t1.price, concat1(t1.onward, t2));
	}
	
	public static Train concat(Train t1, Train t2) {
		Train t = t1;
		while(t.onward != null) {
			t = t.onward;
		}
		t.onward = t2;
		return t1;
	}
	
	public static void print(Train t) {
		System.out.println(t);
		while(t.onward != null) {
			t = t.onward;
			System.out.println(t);
		}
	}
}

class Train {
	int price;
	Train onward;

	public Train(int price, Train onward) {
		super();
		this.price = price;
		this.onward = onward;
	}

	@Override
	public String toString() {
		return "Train [price=" + price + ", onward=" + onward + "]";
	}
}
package chapter10;

import java.util.Optional;

public class CreateOptional {

	public static void main(String[] args) {
		// �����յ�Optional
		Optional<Car> opt1 = Optional.empty();
//		System.out.println(opt1);
		// �׳��쳣
//		System.out.println(opt1.get());
		
		// �þ���ֵ����Optional
		Car car = new Car();
		Optional<Car> opt2 = Optional.of(car);
		// �׳��쳣
//		Optional<Car> opt3 = Optional.of(null);
		
		// ��һ������Ϊ�յ�ֵ����Optional
		Optional<Car> opt4 = Optional.ofNullable(car);
		Optional<Car> opt5 = Optional.ofNullable(null);
	}
}

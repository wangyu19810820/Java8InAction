package chapter10;

import java.util.Optional;

public class CreateOptional {

	public static void main(String[] args) {
		// 创建空的Optional
		Optional<Car> opt1 = Optional.empty();
//		System.out.println(opt1);
		// 抛出异常
//		System.out.println(opt1.get());
		
		// 用具体值创建Optional
		Car car = new Car();
		Optional<Car> opt2 = Optional.of(car);
		// 抛出异常
//		Optional<Car> opt3 = Optional.of(null);
		
		// 用一个可能为空的值创建Optional
		Optional<Car> opt4 = Optional.ofNullable(car);
		Optional<Car> opt5 = Optional.ofNullable(null);
	}
}

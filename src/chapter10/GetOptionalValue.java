package chapter10;

import java.util.NoSuchElementException;
import java.util.Optional;

public class GetOptionalValue {

	public static void main(String[] args) {
		get();
	}
	
	public static void get() {
		Optional<Insurance> opt1 = Optional.ofNullable(null);
		// 简单get
		try {
			opt1.get();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}
		
		// 返回一个新Insurance
		Insurance ins1 = opt1.orElse(new Insurance("Default Insurance"));
		System.out.println(ins1.getName());
		
		// 提供一个构造函数
		Insurance ins2 = opt1.orElseGet(Insurance::new);
		System.out.println(ins2.getName());
		
		// 抛出一个异常
		try {
			opt1.orElseThrow(NoSuchElementException::new);
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}
		
		// 如果有值就打印
		Optional<Insurance> opt2 = Optional.ofNullable(new Insurance("insOne"));
		opt2.ifPresent(System.out::println);
	}
	
	public static void getInsuranceName() {
		Optional<Insurance> optInsurance = Optional.of(new Insurance("insOne"));
		Optional<Car> optCar = Optional.ofNullable(new Car(optInsurance));
		Optional<Person> optPerson = Optional.ofNullable(new Person(optCar));
		
		String name = optPerson.flatMap(Person::getCar)
							   .flatMap(Car::getInsurance)
							   .map(Insurance::getName)
							   .orElse("none insurance name");
		System.out.println(name);
	}
}

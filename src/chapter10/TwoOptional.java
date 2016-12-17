package chapter10;

import java.util.Optional;

public class TwoOptional {

	public static void main(String[] args) {
		Person p = new Person();
		Car c = new Car();
		Optional<Person> optPer1 = Optional.ofNullable(null);
		Optional<Person> optPer2 = Optional.of(p);
		Optional<Car> optCar1 = Optional.empty();
		Optional<Car> optCar2 = Optional.ofNullable(c);
		System.out.println(getCheaptestIns(optPer1, optCar1));
		System.out.println(getCheaptestIns(optPer1, optCar2));
		System.out.println(getCheaptestIns(optPer2, optCar1));
		System.out.println(getCheaptestIns(optPer2, optCar2));
	}
	
	public static String getCheaptestIns(Optional<Person> person, Optional<Car> car) {
		return person.flatMap(p -> {
			return car.map(c -> {
				return getCheapestIns(p, c);
			});
		}).orElse("unknow");
	}

	public static String getCheapestIns(Person person, Car car) {
		if (person == null || car == null) {
			throw (new NullPointerException());
		}
		return "ins_cheap";
	}
}

package chapter10;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;

public class FilterOptional {

	public static void main(String[] args) {
		Optional<Person> optTom = Optional.ofNullable(new Person());
		optTom.ifPresent(p -> p.setName("Tom"));
		Optional<Person> optJack = Optional.ofNullable(new Person());
		optJack.ifPresent(p -> p.setName("Jack"));
		
		Car carBMW = new Car();
		carBMW.setName("BMW");
		Car carBenz = new Car();
		carBenz.setName("Benz");
		
		Insurance ins = new Insurance("insOne");

		// 没车的Tom
		System.out.println(getInsName(optTom));
		// 有Benz车没保险的Tom
		optTom.ifPresent(p -> p.setCar(Optional.ofNullable(carBenz)));
		System.out.println(getInsName(optTom));
		// 有Benz车有保险的Tom
		carBenz.setInsurance(Optional.ofNullable(ins));
		System.out.println(getInsName(optTom));
		// 有宝马车没保险的Tom
		carBMW.setInsurance(Optional.empty());
		optTom.ifPresent(p -> p.setCar(Optional.ofNullable(carBMW)));
		System.out.println(getInsName(optTom));
		// 有宝马车有保险的Tom
		carBMW.setInsurance(Optional.of(ins));
		System.out.println(getInsName(optTom));
		
		// 有宝马车有保险的Jack
		optJack.get().setCar(Optional.of(carBMW));
		System.out.println(getInsName(optJack));
		
		// 空用户
		System.out.println(getInsName(Optional.empty()));
//		System.out.println(getInsName(null));
	}

	// 名字是Tom，汽车是BMW的保险公司名，否则返回Unknow
	public static String getInsName(Optional<Person> opt) {
		return opt.filter(person -> "Tom".equals(person.getName()))
//				  .filter(person -> person.getCar() != null)
				  .flatMap(person -> person.getCar())
				  .filter(car -> "BMW".equals(car.getName()))
//				  .filter(car -> car.getInsurance() != null)
				  .flatMap(Car::getInsurance)
				  .map(Insurance::getName)
				  .orElse("Unknow");
	}
}

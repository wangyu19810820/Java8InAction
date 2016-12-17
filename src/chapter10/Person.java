package chapter10;

import java.util.Optional;

public class Person {

	private Optional<Car> car;
	private String name;
	
	public Person() {
		super();
	}

	public Person(Optional<Car> car) {
		super();
		this.car = car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}
	
	public Optional<Car> getCar() {
		if (this.car != null) {
			return this.car;
		} else {
			return Optional.empty();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [car=" + car + ", name=" + name + "]";
	}
}

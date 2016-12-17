package chapter10;

import java.util.Optional;

public class Car {

	private Optional<Insurance> insurance;
	private String name;
	
	public Car() {
		super();
		this.insurance = Optional.empty();
	}

	public Car(Optional<Insurance> insurance) {
		super();
		this.insurance = insurance;
	}

	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}
	
	public Optional<Insurance> getInsurance() {
		return this.insurance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [insurance=" + insurance + ", name=" + name + "]";
	}
}

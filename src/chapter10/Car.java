package chapter10;

import java.util.Optional;

public class Car {

	private Optional<Insurance> insurance;
	
	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}
	
	public Optional<Insurance> getInsurance() {
		return this.insurance;
	}
}

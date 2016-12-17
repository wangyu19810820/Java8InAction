package chapter10;

public class Insurance {

	private String name;

	public Insurance() {
		super();
		this.name = "Unknow";
	}

	public Insurance(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Insurance [name=" + name + "]";
	}
	
}

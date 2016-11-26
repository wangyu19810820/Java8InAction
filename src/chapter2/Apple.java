package chapter2;

public class Apple extends Fruit {

	private String name;
	private String color;
	private int weight;
	
	public Apple(String name, String color, int weight) {
		this.name = name;
		this.color = color;
		this.weight = weight;
	}
	
	public boolean moreThan150() {
		return weight >= 150;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [name=" + name + ", color=" + color + ", weight=" + weight + "]";
	}
}

package chapter4;

public class Dish {

	public enum Type {Fish, Meat, Other};
	
	private String name;
	private boolean vegentarian;
	private double calories;
	private Type type;
	
	public Dish() {
	}
	
	public Dish(String name, boolean vegentarian, double calories, Type type) {
		this.name = name;
		this.vegentarian = vegentarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVegentarian() {
		return vegentarian;
	}

	public void setVegentarian(boolean vegentarian) {
		this.vegentarian = vegentarian;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", vegentarian=" + vegentarian + ", calories=" + calories + ", type=" + type
				+ "]";
	}
}

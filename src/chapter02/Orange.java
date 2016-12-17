package chapter02;

public class Orange extends Fruit {

	private String name;
	private int level;
	
	public Orange(String name, int level) {
		super();
		this.name = name;
		this.level = level;
	}

	public boolean isGood() {
		return level > 2;
	}
	
	@Override
	public String toString() {
		return "Orange [name=" + name + ", level=" + level + "]";
	}
}

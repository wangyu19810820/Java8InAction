package chapter02;

import java.util.ArrayList;
import java.util.List;

public class FruitInfo<T> {

	private String info;
	private List<Fruit> list;
	private T t;
	
	public FruitInfo(String info, List<Fruit> list) {
		super();
		this.info = info;
		this.list = list;
	}

	public String getInfo() {
		return info;
	}
	
	public List<Fruit> getList() {
		return list;
	}

	public List<? extends Fruit> getAnotherList() {
		return list;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}
	
	public static void main(String[] args) {
		List<Fruit> appleList = new ArrayList<>();
		appleList.add(new Apple("apple1", "red", 100));
		appleList.add(new Apple("apple2", "red", 300));
		appleList.add(new Apple("apple3", "green", 150));
		
		List<Fruit> orangeList = new ArrayList<>();
		orangeList.add(new Orange("Orange1", 3));
		orangeList.add(new Orange("Orange2", 2));
		orangeList.add(new Orange("Orange3", 1));
		
		FruitInfo info1 = new FruitInfo("Apple", appleList);
		FruitInfo info2 = new FruitInfo("Orange", orangeList);
		
		List<? extends Fruit> list1 = info1.getList();
//		list1.add(new Apple("apple4", "green", 250));
		List<Fruit> list2 = info2.getList();
		list2.add(new Orange("Orange4", 4));
		
		List<? extends Apple> list3 = new ArrayList<Apple>();
		List<? extends Fruit> list4 = list3;
		
		for(Fruit fruit : list1) {
			System.out.println(fruit);
		}
		for(Fruit fruit : list2) {
			System.out.println(fruit);
		}
		for(Object o : list3) {
			System.out.println(o);
		}
		for(Object o : list4) {
			System.out.println(o);
		}
		
		FruitInfo<? extends Fruit> info3 = new FruitInfo<>("", null);
		
	}
}

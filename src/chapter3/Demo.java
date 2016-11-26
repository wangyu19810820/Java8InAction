package chapter3;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		List<? extends Integer> list = new ArrayList<Integer>();
//		list.add(new Integer(1));
//		list.add(2);
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		
		list = list1;
//		list.add(null);
//		list.add(new Integer(1));
		
		for (Number i : list) {
			System.out.println(i);
		}
	}
}

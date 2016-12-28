package chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetDemo {

	public static void main(String[] args) {
		List<List<Integer>> l = subset(Arrays.asList(1, 4, 9));
//		List<List<Integer>> l = insertAll(9, Collections.singletonList(Collections.EMPTY_LIST));
		System.out.println(l);
	}
	
	public static List<List<Integer>> subset(List<Integer> l) {
		if (l.isEmpty()) {
			return Collections.singletonList(l);
		}
		
		Integer first = l.get(0);
		List<Integer>sublist = l.subList(1, l.size());
		
		List<List<Integer>> subset1 = subset(sublist);
		List<List<Integer>> subset2 = insertAll(first, subset1);
		return concat(subset1, subset2);
	}
	
	public static List<List<Integer>> insertAll(Integer i, List<List<Integer>> l) {
		List<List<Integer>> newList = new ArrayList<>();
		for (List<Integer> sub : l) {
			List<Integer> temp = new ArrayList<>();
			temp.add(i);
			temp.addAll(sub);
			newList.add(temp);
		}
		return newList;
	}
	
	public static List<List<Integer>> concat(List<List<Integer>> l1, List<List<Integer>> l2) {
		List<List<Integer>> newList = new ArrayList<>();
		newList.addAll(l1);
		newList.addAll(l2);
		return newList;
	}
}

package chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestTransaction {

	public static void main(String[] args) {
		Trader raoul = new Trader(1, "Raoul", "Cambridge");
		Trader mario = new Trader(2, "Mario", "Milan");
		Trader alan = new Trader(3, "Alan", "Cambridge");
		Trader brian = new Trader(4, "Brian", "Cambridge");
		
		List<Transaction> list = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2011, 700),
			new Transaction(alan, 2012, 950)
		);
		
		// 找出2011年所有交易，并按交易额排序（从低到高）
		list.stream().filter(t -> t.getYear() == 2011)
					 .sorted(Comparator.comparing(Transaction::getValue))
					 .forEach(System.out::println);
		
		// 交易员都在那些不同的城市工作过
		list.stream().map(t -> t.getTrader().getCity())
					 .distinct()
					 .forEach(System.out::println);
		
		// 查找所有来自剑桥的交易员，并按姓名排序
		list.stream().map(t -> t.getTrader())
					 .filter(t -> t.getCity().equals("Cambridge"))
					 .distinct()
					 .sorted(Comparator.comparing(Trader::getName))
					 .forEach(System.out::println);
		
		// 返回所有交易员姓名的字符串，并按字母排序
		String nameStr = list.stream().map(t -> t.getTrader().getName())
					 .distinct()
					 .sorted()
//					 .reduce("", (s1, s2) -> s1 + s2 + " ");
					 .collect(Collectors.joining(" "));
		System.out.println(nameStr);
		
		// 有没有交易员在米兰工作的
		boolean workAtMilan = list.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println(workAtMilan ? "有交易员在米兰工作" : "没有交易员在米兰工作");
		
		// 打印在剑桥生活的交易员的所有交易额
		list.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
					 .forEach(t -> System.out.println(t.getValue()));
		
		// 所有交易中，最高的交易额
		Optional<Double> opt1 = list.stream().map(t -> t.getValue())
					 				 		 .reduce(Double::max);
		opt1.ifPresent(System.out::println);
		
		// 交易额最小的交易
		Optional<Transaction> opt2 = list.stream()
//				.reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
				.min(Comparator.comparing(Transaction::getValue));
		opt2.ifPresent(System.out::println);
	}
}

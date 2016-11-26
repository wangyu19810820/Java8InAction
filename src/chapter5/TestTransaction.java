package chapter5;

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
		
		// �ҳ�2011�����н��ף��������׶����򣨴ӵ͵��ߣ�
		list.stream().filter(t -> t.getYear() == 2011)
					 .sorted(Comparator.comparing(Transaction::getValue))
					 .forEach(System.out::println);
		
		// ����Ա������Щ��ͬ�ĳ��й�����
		list.stream().map(t -> t.getTrader().getCity())
					 .distinct()
					 .forEach(System.out::println);
		
		// �����������Խ��ŵĽ���Ա��������������
		list.stream().map(t -> t.getTrader())
					 .filter(t -> t.getCity().equals("Cambridge"))
					 .distinct()
					 .sorted(Comparator.comparing(Trader::getName))
					 .forEach(System.out::println);
		
		// �������н���Ա�������ַ�����������ĸ����
		String nameStr = list.stream().map(t -> t.getTrader().getName())
					 .distinct()
					 .sorted()
//					 .reduce("", (s1, s2) -> s1 + s2 + " ");
					 .collect(Collectors.joining(" "));
		System.out.println(nameStr);
		
		// ��û�н���Ա������������
		boolean workAtMilan = list.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println(workAtMilan ? "�н���Ա����������" : "û�н���Ա����������");
		
		// ��ӡ�ڽ�������Ľ���Ա�����н��׶�
		list.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
					 .forEach(t -> System.out.println(t.getValue()));
		
		// ���н����У���ߵĽ��׶�
		Optional<Double> opt1 = list.stream().map(t -> t.getValue())
					 				 		 .reduce(Double::max);
		opt1.ifPresent(System.out::println);
		
		// ���׶���С�Ľ���
		Optional<Transaction> opt2 = list.stream()
//				.reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
				.min(Comparator.comparing(Transaction::getValue));
		opt2.ifPresent(System.out::println);
	}
}

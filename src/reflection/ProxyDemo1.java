package reflection;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo1 {

	public static class RemberingList implements InvocationHandler {
		private final List<String> proxid = new ArrayList<>();
		
		public Object invoke(Object proxy, Method meth, Object[] args) throws Throwable {
			String name = meth.getName();
			switch (name) {
			case "clear":
				return null;
			case "remove":
			case "removeAll":
				return false;
			}
			return meth.invoke(proxid, args);
		}
	}
	
	public static void main(String[] args) {
		RemberingList h = new RemberingList();
		List<String> l = (List<String>)Proxy.newProxyInstance(List.class.getClassLoader(),
				new Class<?>[]{List.class}, h);
		l.add("aa");
		System.out.println(l);
		l.clear();
		l.remove(0);
		System.out.println(l);
	}
}

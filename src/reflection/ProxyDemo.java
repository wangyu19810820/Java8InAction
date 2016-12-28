package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.Channel;

public class ProxyDemo {

	public static void main(String[] args) throws Exception {
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				switch(methodName) {
				case "isOpen":
					System.out.println("open");
					return false;
				case "close":
					System.out.println("close");
					return null;
				}
				return null;
			}
		};
		
		Channel c = (Channel) Proxy.newProxyInstance(Channel.class.getClassLoader(), 
				new Class[]{Channel.class}, h);
		c.isOpen();
		c.close();
	}

}

package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

	public static void main(String[] args) {
		testPrivate();
		
	}
	
	public static void testPrivate() {
		Class<?> c = ReflectionDemo.class;
		try {
			Object o = c.newInstance();
			Class<?>[] argsTypes = new Class<?>[0];
			Object[] argsValues = null;
			Method meth = c.getDeclaredMethod("clear", argsTypes);
			meth.setAccessible(true);
			meth.invoke(o, argsValues);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testMethod() {
		Object rev = "a";
		Class<?>[] argTypes = new Class<?>[]{};
		Object[] args = null;
		
		try {
			Method meth = rev.getClass().getMethod("hashCode", argTypes);
			Object ret = meth.invoke(rev, args);
			System.out.println(ret);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

	public static void instance() {
		String s;
		try {
			s = ReflectionDemo.class.newInstance().toString();
			System.out.println(s);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "ReflectionDemo";
	}
	
	public String field;
	
	private void clear() {
		System.out.println("clear" + field);
	}

	@Deprecated
	public void deprecatedMethod() {
		
	}
}

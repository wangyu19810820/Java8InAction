package reflection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class MethodTypeDemo {

	public static void lookupDefineClass(Lookup l) {
		MethodType mt = MethodType.methodType(Class.class,
				String.class, byte[].class, int.class, int.class);
		try {
			MethodHandle mh = l.findVirtual(ClassLoader.class, 
					"defineClass", mt);
			System.out.println(mh);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Lookup l = MethodHandles.lookup();
		lookupDefineClass(l);
	}
}

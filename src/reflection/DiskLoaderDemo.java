package reflection;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DiskLoaderDemo {

	public static class DiskLoader extends ClassLoader {
		public DiskLoader() {
			super(DiskLoader.class.getClassLoader());
		}
	
		public Class<?> loadFromDisk(String clzName) throws IOException {
			byte[] b = Files.readAllBytes(Paths.get(clzName));
			return defineClass(null, b, 0, b.length);
		}
	}
	
	public void findDeprecatedMethods(Class<?> clz) {
		for (Method m : clz.getMethods()) {
			for (Annotation a : m.getAnnotations()) {
				if (a.annotationType() == Deprecated.class) {
					System.out.println(m.getName());
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		DiskLoaderDemo d = new DiskLoaderDemo();
		DiskLoader l = new DiskLoader();
		Class<?> cln = l.loadFromDisk("bin\\reflection\\ReflectionDemo.class");
		d.findDeprecatedMethods(cln);
	}

	
}

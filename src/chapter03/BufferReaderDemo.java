package chapter03;

import java.io.IOException;
import java.util.function.Function;

public class BufferReaderDemo {

	public static void main(String[] args) {
		try {
//			print(reader->reader.readLine());
			print(reader->{return reader.readLine() + reader.readLine();});
//			print2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void print(Function<SelfBufferedReader, String> br) throws IOException {
		try(SelfBufferedReader reader = new SelfBufferedReader()) {
			String str = br.apply(reader);
			System.out.println(str);
		} catch (Exception e) {
		}
	}

//	public static void print(BufferReaderInterface br) throws IOException {
//		try(SelfBufferedReader reader = new SelfBufferedReader()) {
//			String str = br.procese(reader);
//			System.out.println(str);
//		} catch (Exception e) {
//		}
//	}
	
	public static void print1() throws IOException {
		try(SelfBufferedReader reader = new SelfBufferedReader()) {
			String str = reader.readLine();
			System.out.println(str);
		} catch (Exception e) {
		}
	}

	public static void print2() throws IOException {
		try(SelfBufferedReader reader = new SelfBufferedReader()) {
			String str = reader.readLine() + reader.readLine();
			System.out.println(str);
		} catch (Exception e) {
		}
	}
}

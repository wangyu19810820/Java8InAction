package chapter3;

public class SelfBufferedReader implements AutoCloseable {

	public SelfBufferedReader() {
	}
	
	public String readLine() {
		return "demo";
	}

	@Override
	public void close() throws Exception {
	}
}

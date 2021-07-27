package multithreading;

public class MultithreadingWithThreadClass {

	public static void main(String[] args) {
		A1 o = new A1();
		B1 o1 = new B1();
		o.start();
		o1.start();

	}

}

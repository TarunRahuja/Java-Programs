package multithreading;
import java.util.*;
public class multithreading {

	public static void main(String[] args) {
		Thread t1 = new Thread(new A());
		Thread t2 = new Thread(new B());
		t1.start();
		t2.start();
	}

}

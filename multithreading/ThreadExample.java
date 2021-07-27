package multithreading;
import java.util.*;
public class ThreadExample {
	public static void main(String[] args) {
		Account a1 = new Account(1000);
		Customer c1 = new Customer(a1, "Tarun");
		Customer c2 = new Customer(a1, "Dhruv");
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
	}

}

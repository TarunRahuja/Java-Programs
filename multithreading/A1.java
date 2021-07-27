package multithreading;

public class A1 extends Thread {
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println("Thread A1 "+i);
		}
	}

}

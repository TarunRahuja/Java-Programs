package multithreading;

public class B1 extends Thread {
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println("Thread B1 "+i);
		}
	}

}

package multithreading;

public class A implements Runnable {

	@Override
	public void run() {
		int i;
		for(i=0; i<=10; i++) {
			System.out.println("Thrad A"+i);
		}
		
	}
		
}

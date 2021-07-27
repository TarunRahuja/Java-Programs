package multithreading;

public class B implements Runnable {

	@Override
	public void run() {
		int i;
		for(i=0; i<=10; i++) {
			System.out.println("Thrad B"+i);
		}
		
	}
		
}

package multithreading;
import java.util.*;
public class Customer implements Runnable {
	private Account account;
	private String name;
	public Customer(Account account,String name) {
		this.account = account;
		this.name = name;
	}
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		synchronized (account) {
			System.out.println("Enter amount to be withdrawn Mr. "+name);
			int amt = sc.nextInt();	
		if(account.isSufficientBalance(amt)) {
			System.out.println(name);
			account.withdraw(amt); 
		}
		else {
			System.out.println("Insufficient balance Mr."+name);
		}
		}	
	}
	
}

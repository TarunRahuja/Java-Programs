package multithreading;

public class Account {
	private int bal;
	public Account(int bal) {
		this.bal = bal;
	}
	public boolean isSufficientBalance(int w) {
		return bal>=w;
	}
	public void withdraw(int amt) {
		bal-=amt;
		System.out.println("Withdrawn money is "+amt);
		System.out.println("Your current balance is"+bal);
	}
}

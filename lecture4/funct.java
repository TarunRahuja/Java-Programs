package lecture4;

import java.util.Scanner;

public class funct {

	public static void main(String[] args) {
		// global variables are defined with static qualifer.
		// if global and local variables have same name,global var is accessed using
		// classname.variable name.
		Scanner sc = new Scanner(System.in);
		int lo = sc.nextInt();
		int hi = sc.nextInt();
		boolean res = false;
		for (int i = lo; i <= hi; i++) {
			res = isPrime(i);
			if (res) {
				System.out.println(i);
			}
		}

	}

	public static boolean isPrime(int n) {
		for (int j = 2; j <=n/2; j++) {
			if (n % j == 0)
				return false;
		}
		return true;

	}

}

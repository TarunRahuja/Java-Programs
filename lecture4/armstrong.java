package lecture4;

import java.util.Scanner;

public class armstrong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lo = sc.nextInt();
		int hi = sc.nextInt();
		boolean res = false;

		for (int i = lo; i <= hi; i++) {
			res = isArms(i);
			if (res)
				System.out.println(i);
		}
	}

	public static boolean isArms(int n) {
		int num = n;
		int nod = countdig(n);
		int sum = 0;
		while (n != 0) {
			int dig = n % 10;
			sum +=(int)Math.pow(dig, nod);//press fn+f3 to see function definition of built-in functions.
			n /= 10;

		}
		if (sum == num)
			return true;
		else
			return false;
	}

	public static int countdig(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n /= 10;
		}
		return count;
	}
}

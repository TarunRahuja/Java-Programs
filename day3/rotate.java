package day3;

import java.util.Scanner;

public class rotate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int rot = sc.nextInt();
		int n = num;
		int count = 0;

		while (n != 0) {
			count++;
			n /= 10;
		}

		rot = rot % count;

		if (rot < 0)
			rot += count;

		int mod = (int) Math.pow(10, rot);
		int mul = (int) Math.pow(10, count - rot);
		int rem = num % mod;
		int q = num / mod;
		int ans = rem * mul + q;
		System.out.println(ans);

	}

}

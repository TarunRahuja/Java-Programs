package day3;

import java.util.Scanner;

public class inverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int ans = 0;
		int pos = 1;
		int n = num;
		while (n != 0) {
			int rem = n % 10;
			ans = ans + pos * (int) Math.pow(10, rem - 1);
			pos++;
			n /= 10;
		}
		System.out.println(ans);

	}

}

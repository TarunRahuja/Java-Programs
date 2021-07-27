package practice;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int row = 1;
		int nst = 1;
		int nsp = n + 1;
		while (row <= n) {
			int cst = 1, csp = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}
			if (row == n)
				cst = 2;
			else
				cst=1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}
			nsp -= 2;
			nst++;
			row++;
			System.out.println();
		}

	}

}

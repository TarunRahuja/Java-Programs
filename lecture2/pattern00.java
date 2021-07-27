package lecture2;

import java.util.Scanner;

public class pattern00 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nsp = 0;
		int nst = n;
		int row = 1;
		while (row <= n) {
			int csp = 1, cst = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			System.out.println();
			row++;
			nst--;
			nsp += 2;
		}

	}

}

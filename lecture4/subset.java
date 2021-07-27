package lecture4;

import java.util.Scanner;

public class subset {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int nod = countdig(num);
		int exp = (int) Math.pow(2, nod);
		//System.out.println(exp);
		int bini = 0;
		int digb = 0, digd = 0;
		for (int i = 0; i < exp; i++) {
			int n = num;
			bini = convbin(i);
			while (bini != 0) {
				digb = bini % 10;
				digd = n % 10;
				if (digb == 1)
					System.out.print(digd);
				bini /= 10;
				n /= 10;

			}
			System.out.println();
		}

	}

	public static int countdig(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			num /= 10;
		}
		return count;
	}

	public static int convbin(int num) {
		int ans = 0, rem = 0, mult = 1;
		while (num != 0) {
			rem = num % 2;
			ans = ans + rem * mult;
			mult = mult * 10;
			num /= 2;
		}
		return ans;
	}

}

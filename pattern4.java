import java.util.Scanner;

public class pattern4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int row = 1;
		int nst = 1;
		// int val=1;
		while (row <= 2*n-1) {
			int cst = 1;

			while (cst <= nst) {
				// if(cst%2==0)
				System.out.print("*");
				// System.out.print("*");
				// System.out.print(val);
				cst++;

			}

			if (row < n) {
				nst += 2;
			} else
				nst -= 2;
			row++;
			System.out.println();
//					if(row<=n/2)
//						  val++;
//					else
//							val--;
		}

	}

}

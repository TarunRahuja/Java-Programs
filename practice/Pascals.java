package practice;
import java.util.Scanner;
public class Pascals {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int row = 1, nst = 1;
		int val = 1;
		while(row<=n)
		{
			int cst = 1;
			while(cst<=nst)
			{
				val = ncr(row-1,cst-1);
				System.out.print(val+"\t");
				cst++;
			}
			nst++;
			row++;
			System.out.println();
		}
	}
	public static int ncr(int n, int r)
	{
		int nr = 1,dra=1,drb=1;
		for(int i = 1; i<=n; i++)
		{
			nr = nr*i;
		}
		for(int i = 1; i<=n-r; i++)
		{
			dra = dra*i;
		}
		for(int i = 1; i<=r; i++)
		{
			drb = drb*i;
		}
		return nr/(dra*drb);
	}

}

package lecture2;
import java.util.Scanner;
public class pattern3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int row=1;
		int nsp=2*n-3;
		int nst=1;
		while(row<=n)
		{
			int csp=1,cst=1;
			while(cst<=nst)
			{
				System.out.print("*");
				cst++;
			}
			
			while(csp<=nsp)
			{
				System.out.print(" ");
				csp++;
			}
		if(row!=n)
		{ cst=1;
			while(cst<=nst)
			{
				System.out.print("*");
				cst++;
			}
		}
		else {
			cst=2;
			while(cst<=nst)
			{
				System.out.print("*");
				cst++;
			}
		}
			System.out.println();
			row++;
			nsp-=2;
			nst++;
		
		

	}

}
}

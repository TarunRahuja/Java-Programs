import java.util.Scanner;
public class pattern5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int row=1;
		int nst=1;
		int val=1;
		while(row<=2*n-1)
		{
			int cst=1;	
		
			while(cst<=nst)
			{
				if(cst%2==0)
					System.out.print("*");
				//System.out.print("*");
				else
					System.out.print(val);
				cst++;
				
			}
			
			if(row<n/2)
			{
				nst+=2;
			}
			else
				nst-=2;
			row++;
			System.out.println();
			if(row<=n-1)
				  val++;
			else
					val--;
		}

	}

}

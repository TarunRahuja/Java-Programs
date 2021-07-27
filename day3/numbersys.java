package day3;
import java.util.Scanner;

public class numbersys {

	public static void main(String[] args) {
		// / by destination multiply by source, works only when dest or src is decimal.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rem=0,ans=0;
		int multiplier = 1;
		while(n!=0)
		{
			rem = n%2;
			ans = ans + multiplier*rem;
			multiplier*=10;
			n/=2;
			
		}
		System.out.println(ans);

	}

}

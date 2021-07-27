package practice;
import java.util.*;
public class recursiveprime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		recpri(a, b, "");
		toh(4,'A','B','C');
	
	}
	public static void recpri(int a, int b, String ans)
	{
		if(a==b)
		{	
			System.out.println(ans);
			return;
		}
		if(isprime(a))
		{
			recpri(a+1, b, ans+a+" ");
		}
		else
			recpri(a+1, b, ans);
	}
	public static boolean isprime(int num) {
		if (num == 1)
			return false;
		if (num == 2)
			return true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}

		}
		return true;
	}
	public static void toh(int nod,char src, char help, char dest)
	{
		if(nod==1)
		{
			System.out.println("Moving disc "+nod+" from "+src+" to "+dest);
			return;
		}
		toh(nod-1,src,dest,help);
		System.out.println("Moving disc "+nod+" from "+src+" to "+dest);
		toh(nod-1,help,src,dest);
	}
}

package practice;
import java.util.Scanner;
public class factorisation {
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 2;
		//int sof = 0;
		//int son = sumdig(n);
		boolean res = false;
		while(n!=0) 
		{
			res = isprime(i);
			if(res)
			{
				while(n%i==0)
				{
					//sof = sof + sumdig(i);
					System.out.print(i+"\t");
					n = n/i;
				}
			}
			i++;
		}
    //if(sof==son)
     //System.out.println(1);
    //else
     //System.out.println(0); 
    }
//    public static int sumdig(int num)
//    {
//        int sum =0;
//        while(num!=0)
//        {
//            sum+=num%10;
//            num/=10;
//        }
//        return sum;
//    }
    public static boolean isprime(int num)
	    {
	        for(int i=2;i<num/2;i++)
	        {
	            if(num%i==0)
	             return false;
	        }
	        return true;
	    }
}
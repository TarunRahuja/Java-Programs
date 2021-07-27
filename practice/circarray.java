package practice;
import java.util.Scanner;
public class circarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int sum = 0;
	    int []arr =new int[n];
	    for(int i = 0; i<n; i++)
	    {
	        arr[i] = sc.nextInt();
	    }
	    int q = sc.nextInt();
	    int [] ans = new int[n];
	    for(int l = 0; l<q; l++)
	    {
	        int x = sc.nextInt();
	        for(int i = 0; i<n; i++)
	        {
	            int addind = (i+n-x)%n;
	            
	            ans[i] = arr[i] + arr[addind];
	           
	        }
	        for(int i = 0; i<n; i++)
		    {
		        arr[i] = ans[i];
		    }

	    }
	      for(int i = 0; i<n; i++)
	      {
	        sum+= ans[i];
	      }
	    System.out.println(sum);
		
	}

}

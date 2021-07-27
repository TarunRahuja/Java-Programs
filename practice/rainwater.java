package practice;
//create an array that stores the max value int the right and left of every
// array value.
/* 2
6
3  0  0  2  0  4
12
0  1  0  2  1  0  1  3  2  1  2  1
        
        */    
import java.util.Scanner;

public class rainwater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int z = 0; z < t; z++)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < arr.length; j++) 
			{
				arr[j] = sc.nextInt();
			}
			int []l = new int[arr.length];
			int []r = new int[arr.length];
			l[0] = 0;
			r[arr.length-1] = arr[arr.length-1];
			for(int i = 1; i<arr.length; i++)
			{
				l[i] = Math.max(arr[i], l[i-1]);
			}
			for(int i = arr.length-2; i>=0; i--)
			{
				r[i] = Math.max(arr[i], r[i+1]);
			}
			int wat = 0;
			for(int i = 0; i<arr.length; i++)
			{
				wat+=Math.min(r[i], l[i]) - arr[i];
			}
			
			System.out.println(wat);
					                          
				
	}
	}
}

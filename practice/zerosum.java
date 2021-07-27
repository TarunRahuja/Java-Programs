package practice;
import java.util.*;
public class zerosum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z = 0; z<t; z++)
		{   int count = 0;
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i<n; i++) 
			{
				arr[i] = sc.nextInt();
			}
			
			for(int si = 0; si<arr.length; si++)
			{
				int sum = 0;
				for(int ei = si; ei<arr.length; ei++)
				{
					sum+=arr[ei];
					if(sum==0)
						count++;
				}
			}
			System.out.println(count);
			
		}

	}
	
}

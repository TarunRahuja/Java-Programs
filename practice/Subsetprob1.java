package practice;
import java.util.*;
public class Subsetprob1 {
	static int count = 0;
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		for(int i = 0; i<n; i++)
		{
			arr[i] = sc.nextInt();
		}
		int tar = sc.nextInt();
		subset(arr, 0, "", tar);
		System.out.println();
		System.out.println(count);
	}
	public static void subset(int []arr, int vidx, String ans,int tar)
	{
		if(vidx==arr.length)
		{
			if(tar==0)
			{
				System.out.print(ans+" ");
				count++;
				return;
			}
			else
				return;
		}
		subset(arr,vidx+1,ans+arr[vidx]+" ",tar-arr[vidx]);
		subset(arr,vidx+1,ans,tar);
	}

}

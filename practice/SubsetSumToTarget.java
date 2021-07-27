package practice;
import java.util.*;
public class SubsetSumToTarget {
    static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		int tar = sc.nextInt();
		for(int i = 0; i<n; i++)
		{
			arr[i] = sc.nextInt();
		}
		Subset(arr,0,tar);
		if(count>0)
			System.out.println("Yes");
			
	}
	public static void Subset(int []arr,int vidx,int tar)
	{
		if(vidx==arr.length)
		{
			if(tar==0)
			{
				count++;
				//System.out.println("Yes");
				return;
			}
			else
			{
				return;
			}
		}
		Subset(arr, vidx+1, tar-arr[vidx]);
		Subset(arr, vidx+1, tar);
	}

}

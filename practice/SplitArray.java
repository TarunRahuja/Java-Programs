package practice;
import java.util.*;
public class SplitArray {
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		for(int i = 0; i<n; i++)
		{
			arr[i] = sc.nextInt();
		}
		split(arr,0, "", "",0, 0);
		System.out.println(count);

	}
	public static void split(int []arr,int vidx,String one, String two,int sum1,int sum2)
	{
		if(vidx==arr.length)
		{
			if(sum1==sum2)
			{
				System.out.print(one+"and ");
				System.out.println(two);
				count++;
				return;
			}
			else
				return;
		}
		
		
			split(arr,vidx+1,one+arr[vidx]+" ",two,sum1+arr[vidx],sum2);
		    split(arr, vidx+1, one, two+arr[vidx]+" ", sum1, sum2+arr[vidx]);
		
	}

}

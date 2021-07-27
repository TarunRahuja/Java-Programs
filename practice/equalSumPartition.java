package practice;
import java.util.*;
public class equalSumPartition {
	static int count = 0;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0; i<n; i++)
		{
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		for(int i = 0; i<n; i++)
		{
			sum = sum+arr[i];
		}
		for(int i = 0; i<n-1; i++)
		{
			for(int j = 0 ; j<n-1-i; j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		//String ri = "";
		splitArray(arr, sum/2, 0, "");
		System.out.println(count);
	}
	public static void splitArray(int []arr,int tar,int last,String ans)
	{
		if(tar==0)
		{
			ArrayList<Integer> copy = new ArrayList<>();
			//left.add(ans);
			for(int i = 0; i<arr.length; i++)
			{
				copy.add(arr[i]);
			}
			for(int i = 0; i<ans.length(); i++)
			{
				for(int j = 0; j<copy.size(); j++)
				{
					if(Integer.parseInt(ans.charAt(i)+"")==copy.get(j))
					{
						copy.remove(j);
						break;
					}
				}
			}
			for(int i = 0; i<ans.length(); i++)
			{
				System.out.print(ans.charAt(i)+" ");
			}
			System.out.print("and ");
			for(int i = 0; i<copy.size(); i++)
			{
				System.out.print(copy.get(i)+" ");
			}
			System.out.println();
			count++;
			return;
		}
		if(tar<0)
		{
			return;
		}
		for(int i = last; i<arr.length; i++)
		{
			splitArray(arr, tar-arr[i], i+1,ans+arr[i]);
		}
	}

}

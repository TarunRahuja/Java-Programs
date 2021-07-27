package reverseArray;
import java.util.Scanner;
public class Subarrays {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		System.out.println("Enter elements");
		for(int i = 0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i<n; i++)
		{
			for(int j = i; j<n;j++)
			{
			  for(int k = i;k<=j;k++)
			  {
				  System.out.print(arr[k]+"\t");
			  }
			  System.out.println();
				
			}
		}

	}

}

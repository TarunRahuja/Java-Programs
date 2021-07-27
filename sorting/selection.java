package sorting;
import java.util.Scanner;
import java.util.Scanner;

public class selection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		int j = 0;
		for(int i = 0; i<=arr.length-2; i++)
		{
			int min = i;
			for( j=i+1; j<n; j++)
			{
				if(arr[j]<arr[min])
					min = j;
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		for(int i = 0;i<n;i++)
		{
			System.out.print(arr[i]+ "\t");
		}
		

	}

}

package reverseArray;
import java.util.Scanner;
public class rotateArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rot = sc.nextInt();
		int n = sc.nextInt();
		int [] arr =new int[n];
		System.out.println("enter elements");
		for(int i = 0 ; i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		if(rot<0)
		{
			rot = (rot%arr.length)+arr.length;
		}
		else
		  rot = rot%arr.length;
		arr = rotate(arr,arr.length,rot);
		for(int i = 0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}

	}
	public static  int[] rotate(int [] arr, int n,int rot)
	{
		
		for(int i = 0 ; i<rot; i++)
		{
			int temp = arr[n-1];
		 for(int j = arr.length-1;j>=1;j--)
		 {
			 arr[j] = arr[j-1];
		 }
		 arr[0] = temp;
			
		}
		return arr;
		
	}

}

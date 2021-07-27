package lecture4;

import java.util.Scanner;

public class array {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeInput();
		display(arr);
		int max = maxof(arr);
		int key = search(arr, 20);
		int binkey = binary(arr,20);
		System.out.println(key);
		System.out.println(binkey);
		System.out.println(max);


	}

	public static int[] takeInput() {

		System.out.println("enter size");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	public static void display(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + "\t");
		}
		System.out.println();
	}

	public static int maxof(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= max)
				max = arr[i];
		}
		return max;

	}

	public static int search(int[] arr, int key) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				index = i;
				return index;
			}

		}
		return -1;
	}
	public static int binary(int []arr,int key)
	{
		int lo = 0, hi = arr.length;
		while(lo<=hi)
		{
			int mid = (lo+hi)/2;
			if(key>arr[mid])
			{
				lo=mid+1;
			}
			
			else if(key<arr[mid])
			{
				hi=mid-1;
			}
			else
			{
				return mid;
			}
		}
			return -1;
		
	}

}

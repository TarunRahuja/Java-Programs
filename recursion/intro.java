package recursion;

import java.util.Scanner;

public class intro {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int x = sc.nextInt();
//		pdi(n);
//		System.out.println(fact(n));
//		System.out.println(pow(x, n));
//		System.out.println(fib(n));
		int[] arr = { 10, 20, 0, 20 };
		int count = 0;
		int max = Integer.MIN_VALUE;
//		System.out.println(maxval(arr, 0, max));
//		System.out.println(search(arr, 0, 20));
		System.out.println(last(arr,0,20));
//		int []ans = findAllIndex(arr,0,20,0);
//		for(int i = 0; i<ans.length; i++)
//		{
//			System.out.print(ans[i]+"\t");
//		}

	}

	public static void pdi(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		pdi(n - 1);
		System.out.println(n);
	}

	public static int fact(int n) {
		if (n == 0)
			return 1;
		else
			return n * fact(n - 1);
	}

	public static int pow(int x, int n) {
		if (n == 0)
			return 1;
		else
			return x * pow(x, n - 1);
	}

	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

	public static int maxval(int[] arr, int vir, int max) {
		if (vir == arr.length)
			return max;
		
		if (arr[vir] > max) {
			max = arr[vir];
		}
		return maxval(arr, vir + 1, max);

	}
	public static int search(int[] arr, int vir, int key) 
	{
		if (vir == arr.length)
			return -1;
		if (arr[vir] == key) 
		{
			return vir;
		}
		return search(arr, vir + 1, key);
	}
	public static int last(int[] arr, int vir, int key) 
	{
		if (vir == arr.length)
			return -1;
		int rr = last(arr, vir + 1, key);
		if (arr[vir] == key && rr==-1) 
		{
			return vir;
		}
		return rr;
	}
	
	public static int[] findAllIndex(int [] arr, int vidx, int key,int count )
	{
		int [] rr;
		if(vidx == arr.length)
		{
			rr = new int[count];
			return rr;
		}
		if(arr[vidx]==key)
		{
			rr = findAllIndex(arr,vidx+1,key,count+1);
			rr[count] = vidx;
		}
		else
		{
			rr = findAllIndex(arr,vidx+1,key,count);
		}
		return rr;
	}
  
}

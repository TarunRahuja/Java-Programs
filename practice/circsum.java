package practice;

import java.util.Scanner;

public class circsum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0, max = 0;
		int temp2 = 0;
		for (int si = 0; temp2 < n; si = (si + 1) % n, temp2++) {
			int ei = si;
			do {
				int temp = 0;
				for (int k = si; temp <n ;k = (k + 1) % n, temp++) 
				{
					if(k==ei)
						break;
					System.out.println(si+" "+ei+ " "+k);
					sum = sum + arr[k];
				}
				ei = (ei + 1) % n;
				if (sum > max)
					max = sum;
				sum = 0;
			}while (ei != si);
		}
		System.out.println(max);

	}
}

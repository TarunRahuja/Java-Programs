package reverseArray;

import java.util.Scanner;

public class reverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter elements");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		arr = reverse(arr, arr.length);
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + "\t");
		}
	}

	public static int[] reverse(int[] arr, int n) {
		for (int i = 0; i <= n / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[n - 1 - i];
			arr[n - 1 - i] = temp;
		}
		return arr;
	}

}

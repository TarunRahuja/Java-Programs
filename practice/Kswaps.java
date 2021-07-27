package practice;

import java.util.*;

public class Kswaps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String num = n + "";
		int[] arr = new int[num.length()];
		for (int i = 0; i < num.length(); i++) {
			arr[i] = Integer.parseInt(num.substring(i, i + 1));
		}
		swaps(arr, 0, k);

	}

	public static void swaps(int[] arr, int vidx, int k) {
		if (k == 0) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			return;
		}
		if (vidx + 1 < arr.length && arr[vidx] < arr[vidx + 1]) {
			int temp = arr[vidx];
			arr[vidx] = arr[vidx + 1];
			arr[vidx + 1] = temp;

			swaps(arr, vidx + 1, k - 1);

			temp = arr[vidx];
			arr[vidx] = arr[vidx + 1];
			arr[vidx + 1] = temp;
		}
		if (vidx + 1 < arr.length && arr[vidx] >= arr[vidx + 1]) {
			swaps(arr, vidx + 1, k);
		}
	}

}

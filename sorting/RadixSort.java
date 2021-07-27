package sorting;
import java.util.*;
public class RadixSort {
	public static void main(String[] args) {
		int[] arr = {213,97,718,123,37,443,982,64,375,683};
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		for(int val : arr) {
			max = Math.max(max, val);
		}
		int exp = 1;
		while(exp <= max) {
			countSort(arr, exp);
			exp *= 10;
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void countSort(int[] arr, int exp) {
		int n = arr.length;
		int[] freq = new int[10];
		for(int val : arr) {
			freq[val/exp % 10]++;
		}
		for(int i=1; i<=9; i++) {
			freq[i] += freq[i-1];
		}
		int[] ans = new int[n];
		for(int i=n-1; i>=0; i--) {
			int pos = --freq[(arr[i] / exp) % 10];
			ans[pos] = arr[i];
		}
		for(int i=0; i<n; i++) {
			arr[i] = ans[i];
		}
	}
}
package sorting;
import java.util.*;
public class CountSort {
	public static void main(String[] args) {
		int[] arr = {1,4,2,9,2,2,7,6,4,2,1,8,4};
		int n = arr.length;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int val : arr) {
			min = Math.min(min, val);
			max = Math.max(max, val);
		}
		int[] freq = new int[max-min+1];
		for(int val : arr) {
			freq[val-min]++;
		}
		freq[0]--;
		for(int i=1; i<freq.length; i++) {
			freq[i] += freq[i-1];
		}
		int[] ans = new int[n];
		for(int i=n-1; i>=0; i--) {
			int val = arr[i];
			ans[freq[val-min]--] = val;
		}
		System.out.println(Arrays.toString(ans));
	}
}
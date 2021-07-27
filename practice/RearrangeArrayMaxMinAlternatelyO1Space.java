package practice;
import java.util.*;
public class RearrangeArrayMaxMinAlternatelyO1Space {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7};
		int n = arr.length;
		int min = 0, max = n-1, mod = arr[n-1] + 1;
		for(int i=0; i<n; i++) {
			if(i % 2 == 0) {
				arr[i] += (arr[max] % mod) * mod;
				max--;
			}
			else {
				arr[i] += (arr[min] % mod) * mod;
				min++;
			}
		}
		for(int i=0; i<n; i++) {
			arr[i] /= mod;
		}
		System.out.println(Arrays.toString(arr));
	}
}

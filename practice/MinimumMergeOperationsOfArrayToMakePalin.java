package practice;
import java.util.*;
public class MinimumMergeOperationsOfArrayToMakePalin {
	public static void main(String[] args) {
		int[] arr = new int[] {1,4,5,1};
		int n = arr.length;
		int left = 0, right = n-1, ans = 0;
		while(left <= right) {
			if(arr[left] == arr[right]) {
				left++;
				right--;
			}
			else if(arr[left] < arr[right]) {
				left++;
				if(left <= right) {
					arr[left] += arr[left-1];
				}
				ans++;
			}
			else {
				right--;
				if(right >= left) {
					arr[right] += arr[right+1];
				}
				ans++;
			}
		}
		System.out.println(ans);
	}
}

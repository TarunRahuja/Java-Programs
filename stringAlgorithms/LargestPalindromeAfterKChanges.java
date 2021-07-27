//Make largest palindrome by changing at most K-digits
package stringAlgorithms;
import java.util.*;
public class LargestPalindromeAfterKChanges {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();
		int n = str.length();
		char[] arr = str.toCharArray();
		int left = 0, right = n-1;
		while(left < right) {
			if(arr[left] != arr[right]) {
				if(arr[left] >= arr[right]) {
					arr[left] = arr[right] = arr[left];
				}
				else {
					arr[left] = arr[right] = arr[right];
				}
				k--;
			}
			left++;
			right--;
		}
		if(k < 0) {
			System.out.println("Not Possible");
		}
		else {
			left = 0;
			right = n-1;
			while(left <= right) {
				if(left == right) {
					if(k > 0) {
						arr[left] = '9';
					}
				}
				if(arr[left] < '9') {
					if(arr[left] == str.charAt(left) && arr[right] == str.charAt(right) && k>=2) {
						arr[left] = arr[right] = '9';
						k -= 2;
					}
					if((arr[left] != str.charAt(left) || arr[right] != str.charAt(right)) && k>=1) {
						arr[left] = arr[right] = '9';
						k--;
					}
				}
				left++;
				right--;
			}
			System.out.println(new String(arr));
		}
	}
}
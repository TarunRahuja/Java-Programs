package stringAlgorithms;
import java.util.*;
public class LongestNonPalindromicSubstring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean isPalindrome = true;
		int n = str.length();
		int left = 0, right = n-1;
		while(left < right) {
			if(str.charAt(left) != str.charAt(right)) {
				isPalindrome = false;
				break;
			}
			left++;
			right--;
		}
		if(isPalindrome) {
			System.out.println(n-1);
		}
		else {
			System.out.println(n);
		}
	}

}

package stringAlgorithms;
import java.util.*;
public class LexicographicallySmallestPalindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] freq = new int[26];
		int n = str.length();
		for(int i=0; i<n; i++) {
			freq[str.charAt(i)-'a']++;
		}
		char[] arr = new char[n];
		int k = 0, count = 0;
		for(int val : freq) {
			if(val % 2 != 0) {
				count++;
			}
		}
		if(count >= 2) {
			System.out.println("Not Possible");
			return;
		}
		for(int i=0; i<26; i++) {
			if(freq[i] % 2 == 1) {
				while(freq[i] > 1) {
					arr[k] = arr[n-1-k] = (char)('a'+i);
					k++;
					freq[i] -= 2;
				}
				arr[n/2] = (char)('a'+i);
			}
			else {
				while(freq[i] > 0) {
					arr[k] = arr[n-1-k] = (char)('a'+i);
					k++;
					freq[i] -= 2;
				}
			}
		}
		System.out.println(new String(arr));
	}
}
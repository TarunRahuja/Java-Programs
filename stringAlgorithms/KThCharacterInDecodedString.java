package stringAlgorithms;
import java.util.*;
public class KThCharacterInDecodedString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();
		int n = str.length();
		int count = 0;
		for(int i=0; i<n; ) {
			int j = i+1;
			while(j < n) {
				if(Character.isDigit(str.charAt(j))) {
					break;
				}
				j++;
			}
			int freq = 0;
			int l = j;
			while(l < n) {
				if(!Character.isDigit(str.charAt(l))) {
					break;
				}
				freq = (freq * 10) + (str.charAt(l) - '0');
				l++;
			}
			count += (freq*(j-i));
			if(count >= k) {
				k--;
				k %= (j-i);
				System.out.println(str.charAt(i+k));
				return;
			}
			else {
				k -= count;
				i = l;
				count = 0;
			}
		}
	}
}
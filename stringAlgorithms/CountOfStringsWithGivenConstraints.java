package stringAlgorithms;
import java.util.*;
public class CountOfStringsWithGivenConstraints {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = str.length();
		int prod = 1;
		for(int i=0; i<n; i++) {
			HashSet<Character> uniqueOptions = new HashSet<>();
			if(i - 1 >= 0) {
				uniqueOptions.add(str.charAt(i-1));
			}
			if(i + 1 < n) {
				uniqueOptions.add(str.charAt(i+1));
			}
			uniqueOptions.add(str.charAt(i));
			prod *= uniqueOptions.size();
		}
		System.out.println(prod);
	}

}

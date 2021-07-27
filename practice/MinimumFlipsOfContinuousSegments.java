package practice;
import java.util.*;
public class MinimumFlipsOfContinuousSegments {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = str.length();
		int oneSegments = 0;
		int zeroSegments = 0;
		for(int i=0; i<n; ) {
			int j = i+1;
			char curr = str.charAt(i);
			if(curr == '0') {
				zeroSegments++;
			}
			else {
				oneSegments++;
			}
			while(j<n && str.charAt(j) == curr) {
				j++;
			}
			i = j;
		}
		System.out.println(Math.min(oneSegments, zeroSegments));
	}
}

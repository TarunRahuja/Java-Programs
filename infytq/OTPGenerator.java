package infytq;
import java.util.*;
public class OTPGenerator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		String ans = new String();
		for(int i=1; i<num.length(); i+=2) {
			int n = num.charAt(i) - '0';
			ans = ans + (n*n);
		}
		System.out.println(ans.substring(0, 4));
	}
}

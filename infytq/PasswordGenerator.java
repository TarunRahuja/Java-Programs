package infytq;
import java.util.*;
public class PasswordGenerator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.next();
		String ans = new String();
		String []arr = inp.split(",");
		for(String str : arr) {
			String []temp = str.split(":");
			int maxLessThanLen = getfloor(temp[1].toCharArray(), temp[0].length());
			if(maxLessThanLen == -1) {
				ans = ans + 'X';
			}
			else {
				ans = ans + temp[0].charAt(maxLessThanLen - 1);
			}
		}
		System.out.println(ans);
	}
	public static int getfloor(char []a, int x) {
		int ans  = -1;
		for(char c : a) {
			if(c - '0' <= x && c - '0'>ans) {
				ans = c - '0';
			}
		}
		return ans;
	}
}
//sample Input
//Abhishek:34848,Mayur:4739,Friends:2949,Yeah:9889
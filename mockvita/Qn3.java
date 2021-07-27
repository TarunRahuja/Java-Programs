package mockvita;
import java.util.*;
public class Qn3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int minl = sc.nextInt();
		int maxl = sc.nextInt();
		int minb = sc.nextInt();
		int maxb = sc.nextInt();
		int ans = 0;
		for(int i=minl; i<=maxl; i++) {
			for(int j=minb; j<=maxb; j++) {
				ans = ans + helper(i, j);
			}
		}
		System.out.println(ans);
	}
	public static int helper(int a, int b, int [][]dp) {
		if(a == b) {
			return 1;
		}
		if(dp[a][b] != 0) {
			return dp[a][b];
		}
		int h = 999999;
		int v = 999999;
		for(int i=1; i<=a/2; i++) {
			v = Math.min(v, helper(i,b,dp) + helper(a-i,b,dp));
		}
		for(int i=1; i<=b/2; i++) {
			h = Math.min(h, helper(a,i,dp) + helper(a,b-i,dp));
		}
		return dp[a][b] = Math.min(h, v);
	}
	public static int helper(int a, int b) {
		int small = Math.min(a, b);
		int big = Math.max(a, b);
		int ans = 0;
		while(small != 0) {
			ans = ans + (big/small);
			big = big%small;
			int temp = big;
			big = small;
			small = temp;
		}
		return ans;
	}
}
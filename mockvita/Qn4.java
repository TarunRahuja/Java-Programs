package mockvita;
import java.util.*;
public class Qn4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		String []arrs = in.split(" ");
		int n = arrs.length;
		int []arr = new int[n];
		int sum = 0;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(arrs[i]);
			sum += arr[i];
		}
		boolean [][] dp = new boolean[n+1][sum+1];
		for(int j=0; j<sum+1; j++) {
			dp[0][j] = false;
		}
		for(int i=0; i<=n; i++) {
			dp[i][0] = true;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<dp[i].length; j++) {
				boolean res = false;
				if(j >= arr[i-1]) {
					res = res || dp[i-1][j-arr[i-1]];
				}
				res = res || dp[i-1][j];
				dp[i][j] = res;
			}
		}
		int minDiff = 9999999;
		int time = -1;
		for(int j=0; j<dp[0].length/2+1; j++) {
			if(dp[n-1][j]) {
				if(sum-2*j < minDiff) {
					minDiff = sum - 2*j;
					time = Math.max(j, sum-j);
				}
			}
		}
		System.out.println(time);
	}
}
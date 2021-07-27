package codevita;
import java.util.*;
public class Solution5 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int d = sc.nextInt();
		int []arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		long []dp = new long[n];
		Arrays.fill(dp, -1);
		long a = helper(arr,w);
		Arrays.fill(dp, -1);
		long b = helper(arr,w+d);
		if(a>b) {
			System.out.println("Wrong " + Math.abs(a-b));
		}
		else if(b>a) {
			System.out.println("Right " + Math.abs(a-b));
		}
		else {
			System.out.println("Both are Right");
		}
	}
	public static long helper(int []arr, int vidx, int w, long []dp) {
		if(vidx >= arr.length) {
			return 0;
		}
		long max = 0;
		long sum = 0;
		if(dp[vidx] != -1) {
			return dp[vidx];
		}
		max = Math.max(max, helper(arr,vidx+w,w,dp));
		for(int i = vidx; i<vidx + w && i < arr.length; i++) {
			sum += arr[i];
			max = Math.max(max, helper(arr,i+2,w,dp)+sum);
			max = Math.max(max, helper(arr,i+1,w,dp));
		}
		return dp[vidx] = max;
	}
	public static long helper(int []arr, int w) {
		long max = 0;
		int n = arr.length;
		long []dp = new long[n+1];
		dp[n] = 0;
		for(int i=n-1; i>=0; i--) {
			long sum = 0;
			for(int j=i; j<i+w && j<arr.length; j++) {
				sum += arr[j];
				max = Math.max(max, sum);
				if(j+2<n+1)
				  max = Math.max(max, dp[j+2]+sum);
				if(j+1<n+1)
				  max = Math.max(max, dp[j+1]);
			}
			if(i+w < n+1) {
				max = Math.max(max, dp[i+w]);
			}
			dp[i] = max;
		}
		return dp[0];
	}
}
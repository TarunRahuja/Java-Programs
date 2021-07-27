package codevita;
import java.util.*;
public class Solution3 {
	final static int mod = (int)Math.pow(10, 9) + 7;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		int h = sc.nextInt();
		int []arr = new int[n];
		long total = 0;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			int tempVol = arr[i];
			tempVol = ((tempVol % mod)*(b%mod))%mod;
			tempVol = ((tempVol % mod)*(h%mod))%mod;
			total = ((total % mod) + (tempVol)%mod)%mod;
		}
		long largest = getLargestCuboid(arr, b, h);
		System.out.println(total - largest);
	}
	public static long getLargestCuboid(int []arr, int b, int h) {
		long ans = 0;
		Stack<Integer>st = new Stack<>();
		int n = arr.length;
		for(int i=0; i<n; i++) {
			while(!st.empty() && arr[i] < arr[st.peek()]) {
				int val = st.pop();
				int lval = -1;
				if(!st.empty()) {
					lval = st.peek(); 
				}
				long tempVol = (((i - lval - 1)%mod)*(arr[val]%mod))%mod;
				tempVol = ((tempVol % mod)*(b%mod))%mod;
				tempVol = ((tempVol % mod)*(h%mod))%mod;
				ans = Math.max(ans, tempVol);
			}
			st.push(i);
		}
		while(!st.empty()) {
			int val = st.pop();
			int lval = -1;
			if(!st.empty()) {
				lval = st.peek(); 
			}
			long tempVol = (((n - lval - 1)%mod)*(arr[val]%mod))%mod;
			tempVol = ((tempVol % mod)*(b%mod))%mod;
			tempVol = ((tempVol % mod)*(h%mod))%mod;
			ans = Math.max(ans, tempVol);
		}
		return ans;
	}
}
package codevita;
import java.util.*;
import java.io.*;
public class Solution1 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char [][]arr = new char[n][n];
		for(int i=0; i<n; i++) {
			String row = br.readLine();
			String []arrs = row.split(" ");
			for(int j=0; j<n; j++) {
				arr[i][j] = arrs[j].charAt(0);
			}
		}
		char [][]once = rotateMatrix(arr);
		char [][]twice = rotateMatrix(once);
		char [][]thrice = rotateMatrix(twice);
		removeD(arr);
		removeD(once);
		removeD(thrice);
		removeD(twice);
		trickleDown(arr);
		trickleDown(once);
		trickleDown(twice);
		trickleDown(thrice);
		int ans1 = getBiggestSquare(arr);
		int ans2 = getBiggestSquare(once);
		int ans3 = getBiggestSquare(twice);
		int ans4 = getBiggestSquare(thrice);
		System.out.println(Math.max(ans1, Math.max(ans2, Math.max(ans3, ans4))));
	}
	public static void display(char [][]arr) {
		for(char []a : arr) {
			for(char val : a) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
	public static int getBiggestSquare(char [][]arr) {
		int n = arr.length;
		int [][]dp = new int[n+1][n+1];
		int max = 0;
		for(int i=n-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				if(arr[i][j] == '-') {
					dp[i][j] = Math.min(dp[i][j+1], Math.min(dp[i+1][j+1], dp[i+1][j]))+1;
				}
				else {
					dp[i][j] = 0;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
	public static void trickleDown(char [][]arr) {
		int n = arr.length;
		for(int i=n-2; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				if(arr[i][j] != 'C')continue;
				int r = i;
				int c = j;
				boolean flag = false;
				while(r+1<n && arr[r+1][c] == '-') {
					flag = true;
					r++;
				}
				if(flag) {
					arr[r][c] = 'C';
					arr[i][j] = '-';
				}
			}
		}
	}
	public static void removeD(char [][]arr) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 'D') {
					arr[i][j] = '-';
				}
			}
		}
	}
	public static char[][] rotateMatrix(char [][]arr){
		int n = arr.length;
		char [][]res = new char[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				res[i][j] = arr[j][i];
			}
		}
		return res;
	}
}
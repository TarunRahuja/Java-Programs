package practice;
import java.util.*;
public class PracticeArrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int []arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(perfectArray(arr,0,k,0));
		}

	}
	public static int perfectArray(int []arr,int vidx,int k,int count) {
		
		if(vidx==arr.length) {
			int c = 0;
			for(int i=1; i<arr.length; i++) {
				if(arr[i]!=arr[i-1]) {
					c++;
				}
			}
			if(c>k)
				return Integer.MAX_VALUE;
			return count;
		}
		int exclude = perfectArray(arr, vidx+1, k,count);
		int include = 0;
		if(vidx-1>=0) {
		if(arr[vidx]!=arr[vidx-1]) {
			arr[vidx] = arr[vidx-1];
			include = perfectArray(arr, vidx+1, k,count+1);
			}
		}	
		return Math.min(exclude,include);
	}
	

}

package practice;
import java.util.*;
public class HackerEarthTestHousePaint {
	    public static void main(String args[] ) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        while(t-->0){
	            int n = sc.nextInt();
	            int m = sc.nextInt();
	            int k = sc.nextInt();
	            int []arr = new int[n];
	            for(int i=0; i<n; i++){
	                arr[i] = sc.nextInt();
	            }
	            long [][][]dp = new long[n][k+1][m+1];
	            for(long [][]a:dp){
	                for(long []temp:a){
	                    Arrays.fill(temp,-1);
	                }
	            }
	            long [][]cost = new long[n][m];
	            for(int i=0; i<n; i++){
	                for(int j=0; j<m; j++){
	                    cost[i][j] = sc.nextLong();
	                }
	            }
	            System.out.println(helper(arr,0,cost,k,-1,dp));
	        }
	    }
	    public static long helper(int []arr, int vidx, long [][]cost, int k, int prev, long [][][]dp){
	        if(vidx==arr.length){
	            if(k==0){
	                return 0;
	            }
	            else{
	                return Integer.MAX_VALUE;
	            }
	        }
	        if(k<0){
	            return Integer.MAX_VALUE;
	        }
	        if(k>=0 && prev>=0 && dp[vidx][k][prev]!=-1)return dp[vidx][k][prev];
	        long min = Integer.MAX_VALUE;
	        if(arr[vidx]==0){
	            if(vidx==0){
	                for(int i=1; i<=cost[0].length; i++){
	                    min = Math.min(min,helper(arr,vidx+1,cost,k-1,i,dp)+cost[0][i-1]);
	                }
	            }
	            else{
	                for(int i=1; i<=cost[0].length; i++){
	                    if(i==prev){
	                       min = Math.min(min,helper(arr,vidx+1,cost,k,i,dp)+cost[vidx][i-1]);
	                    }
	                    else{
	                        min = Math.min(min,helper(arr,vidx+1,cost,k-1,i,dp)+cost[vidx][i-1]);
	                    }
	                }
	            }
	        }
	        else{
	            if(vidx==0){
	                min = Math.min(min,helper(arr,vidx+1,cost,k-1,arr[vidx],dp));
	            }
	            else{
	                if(arr[vidx]==prev){
	                    min = Math.min(min,helper(arr,vidx+1,cost,k,arr[vidx],dp));
	                }
	                else{
	                    min = Math.min(min,helper(arr,vidx+1,cost,k-1,arr[vidx],dp));
	                }
	            }
	        }
	        if(prev>=0 && k>=0)
	          dp[vidx][k][prev] = min;
	        return min;
	    }
	}
package twoDArray;
public class LargestSumSubmatrix {
	static class Kadane{
		int sum;
		int si;
		int ei;
		public Kadane(int sum, int si, int ei) {
			this.sum = sum;
			this.si = si;
			this.ei = ei;
		}
	}
	public static void main(String[] args) {
		int arr[][] = new int[][] {{1, 2, -1, -4, -20},  
            {-8, -3, 4, 2, 1},  
            {3, 8, 10, 1, 3},  
            {-4, -1, 1, 7, -6}};
		int rows = arr.length;
		int cols = arr[0].length;
		int global = Integer.MIN_VALUE;
		int [] rowSumVector = new int[rows];
		for(int l=0; l<cols; l++) {
			rowSumVector = new int[rows];
			for(int r=l; r<cols; r++) {
				for(int i=0; i<rowSumVector.length; i++) {
					rowSumVector[i]+= arr[i][r];
				}
				Kadane maxSum = kadane(rowSumVector);
				global = Math.max(maxSum.sum,global);
			}
		}
		System.out.println(global);
	}
	public static Kadane kadane(int []rowSumVector) {
		Kadane []dp = new Kadane[rowSumVector.length];
		for(int i=0; i<dp.length; i++) {
			dp[i] = new Kadane(0, 0, 0);
		}
		dp[0] = new Kadane(rowSumVector[0],0,0);
		for(int i=1; i<rowSumVector.length; i++) {
		     if(rowSumVector[i]>rowSumVector[i]+dp[i-1].sum) {
		    	 dp[i] = new Kadane(rowSumVector[i],i,i);
		     }
		     else{
		    	 dp[i] = new Kadane(rowSumVector[i]+dp[i-1].sum,dp[i-1].si,i);
		     }
		}
		Kadane max = new Kadane(Integer.MIN_VALUE,-1,-1);
		for(int i=0; i<dp.length; i++) {
			if(dp[i].sum>max.sum) {
				max.sum = dp[i].sum;
				max.si = dp[i].si;
				max.ei = dp[i].ei;
			}
		}
		return max;
	}

}

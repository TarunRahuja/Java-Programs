package codevita;
import java.util.*;
import java.io.*;
public class Solution2 {
	static class Fast 
	{ 
		BufferedReader br; 
		StringTokenizer st; 

		public Fast() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
				{  
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{  
			} 
			return str; 
		} 
	} 

	public static void main(String[] args)throws IOException {
		Fast sc = new Fast();
		int n = sc.nextInt();
		int maxVal = 0;
		int []arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			maxVal = Math.max(maxVal, arr[i]);
		}
		int msb = getBitLimit(maxVal);
		HashMap<Integer,int[]>map = new HashMap<>();
		for(int val : arr) {
			int setBits = getSetBits(val, msb);
			int offBits = msb - setBits;
			map.put(val, new int[] {offBits,setBits});
		}
//		System.out.println(maxVal);
//		System.out.println(msb);
		ArrayList<ArrayList<Integer>>superSet = new ArrayList<ArrayList<Integer>>();
		generateSubsets(arr,0,new ArrayList<Integer>(), superSet);
		//System.out.println(superSet);
		int count = 0;
		for(ArrayList<Integer>subset : superSet) {
			if(isBinaryEquivalent(subset, msb,map)) {
				count++;
			}
		}
		System.out.println(getResult(count, msb));
	}
	public static String getResult(int count, int lim) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<lim; i++) {
			int mask = (1 << i);
			if((count & mask) != 0) {
				sb.append('1');
			}
			else {
				sb.append('0');
			}
		}
		sb = sb.reverse();
		return sb.toString();
	}
	public static boolean isBinaryEquivalent(ArrayList<Integer>subset, int lim,HashMap<Integer,int[]>map) {
		int totalZeros = 0, totalOnes = 0;
		for(int val : subset) {
			int currOnes = map.get(val)[1];
			int currZeros = map.get(val)[0];
			//System.out.println("val = " + val + " CurrOnes = " + currOnes + " currZeros = " + currZeros);
			totalOnes += currOnes;
			totalZeros += currZeros;
		}
//		System.out.println("Subset  = " + subset);
//		System.out.println("Total Zeros = " + totalZeros + " Total Ones = " + totalOnes);
		return totalOnes == totalZeros;
	}
	public static int getSetBits(int val, int lim) {
		int ans =  0;
		for(int i=0; i<lim; i++) {
			int mask = (1 << i);
			if((val & mask) != 0) {
				ans++;
			}
		}
		return ans;
	}
	public static int getBitLimit(int val) {
		int count = 0;
		while(val != 0) {
			count++;
			val = val >> 1;
		}
		return count;
	}
	public static void generateSubsets(int []arr,ArrayList<Integer>subset, ArrayList<ArrayList<Integer>>superSet) {
		int n = arr.length;
		int count = (int)Math.pow(2, n);
		for(int i=1; i<count; i++) {
			subset = new ArrayList<Integer>();
			for(int j=0; j<n; j++) {
				int mask = (1<<j);
				if((i & mask) != 0) {
					subset.add(arr[j]);
				}
			}
			superSet.add(new ArrayList<Integer>(subset));
		}
		//System.out.println(superSet);
	}
	public static void generateSubsets(int []arr,int vidx,ArrayList<Integer>subset, ArrayList<ArrayList<Integer>>superSet) {
		if(vidx == arr.length) {
			if(subset.size() > 0) {
				superSet.add(new ArrayList<Integer>(subset));
			}
			return;
		}
		subset.add(arr[vidx]);
		generateSubsets(arr,vidx+1, subset, superSet);
		subset.remove(subset.size()-1);
		generateSubsets(arr,vidx+1, subset, superSet);
	}
}
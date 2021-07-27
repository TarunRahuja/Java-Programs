package DynamicProgramming;

import java.util.Arrays;

import firstex.boole;

public class DP {

	public static void main(String[] args) {
//	System.out.println(fibonacciTD(5, new int[6]));
//	System.out.println(fibonacciBU(5, new int[6]));
//	fibonacciBUSE(5);
//	System.out.println(boardpathtd(0, 10, new int[11]));
//	boardpathBu(0, 10);
//	BoardPathBUSE(0, 10);
	//System.out.println(MazePathTD(0, 0, 2, 2,new int[3][3]));
	//MazePathBUSE(0, 0, 3, 3);
	//System.out.println((LCSBU("abcd", "agcfd")));
	int [][]strg = new int[4][4];
//	for(int i = 0; i<strg.length; i++)
//	{
//		Arrays.fill(strg[i], -1);
//	}
	int [] mix = {40,60,20,30};
	int [] prices = {0,2,10,20,11,12,13};
	int[] wt = {1,3,4,5};
	int []price = {1,4,5,7};
	int cap = 7;
	int [][]strgk = new int[4][8];
	//System.out.println(knapsnack(wt, price, 0, cap));
	//System.out.println(knapsnackBU(wt, price, cap));
	//System.out.println(mixtureBU(mix));
	//System.out.println(rodcutBU(prices));
	System.out.println(palincutsBU("ababba"));
	//System.out.println(wineprobBU(prices));
	//System.out.println(wildcardBU("abdkkm", "****?**l"));
	//System.out.println(wineprobTD(prices, 0, prices.length-1, strg));
	//System.out.println(EditDistanceBU("abcd", "agcfd"));
//	int []arr = {1,2,3,4,5};
//	int [][]strg1 = new int[arr.length][arr.length];
//	for(int i = 0; i<strg1.length; i++) {
//	  Arrays.fill(strg1[i], -1);
//	}
	//System.out.println(chainmultBU(arr));
	//System.out.println((LCSTD("abcd", "agcfd",strg)));

	}
	public static int fibonacciTD(int n,int []strg)
	{
		if(n==0||n==1)
			return n;
		if(strg[n]!=0)
		{
			return strg[n];
		}
		int fnm1 = fibonacciTD(n-1, strg);
		int fnm2 = fibonacciTD(n-2, strg);
		int fn = fnm1+fnm2;
		strg[n] = fn;
		return fn;
	}
	public static int fibonacciBU(int n, int[] strg)
	{
		strg[0] = 0;
		strg[1] = 1;
		for(int i = 2; i<strg.length; i++)
		{
			strg[i] = strg[i-1]+strg[i-2];
		}
		return strg[n];
	}
	public static void fibonacciBUSE(int n)
	{
		int old = 0;
		int current = 1;
		int newn = 0;
		for(int i = 0; i<=n-2; i++)
		{
			newn = old+current;
			old = current;
			current = newn;
		}
		System.out.println(newn);
	}
	public static int boardpathtd(int curr,int end,int[]strg)
	{
		if(curr==end)
		{
			return 1;
		}
		if(curr>end)
			return 0;
		if(strg[curr]!=0)
			return strg[curr];
		int c = 0;
		for(int dice = 1; dice<=6; dice++)
		{
			c+=boardpathtd(curr+dice, end, strg);
		}
		strg[curr] = c;
		return c;
	}
	public static void boardpathBu(int curr,int end)
	{
		 int [] strg = new int[end+1];
		 strg[strg.length-1] = 1;
		 strg[strg.length-2] = 1;
		 for(int i = strg.length-3;i>=0; i--)
		 {
			 for(int j = i;j<=i+6; j++)
			 {
				 if(j<strg.length)
				 {
					 strg[i]+= strg[j];
				 }
			 }
		 }
		 System.out.println(strg[0]);
	}
	public static void BoardPathBUSE(int curr,int end)
	{
		int []strg = new int[6];
		strg[0] = 1;
		for(int i = end-1; i>=curr;i--)
		{
			int sum = 0;
           for(int k = 0; k<strg.length;k++)
           {
        	   sum+=strg[k];
           }
           for(int j = strg.length-1;j>0;j--)
           {
        	   strg[j] = strg[j-1];
           }
           strg[0] = sum;
//			for(int j = 1;j<6; j++)
//			{
//				int temp = strg[j];
//				strg[j] = strg[j-1];
//				strg[j-1] = strg[j-1]+temp;
//			}
			
		}
		System.out.println(strg[0]);
	}
	public static int MazePathTD(int cr,int cc,int er, int ec,int [][]strg)
	{
		if(cr==er&&cc==ec)
		{
			return 1;
		}
		if(cr>er||cc>ec)
		{
			return 0;
		}
		if(strg[cr][cc]!=0)
		{
			return strg[cr][cc];
		}
		int vw = 0;
		vw+=MazePathTD(cr+1, cc, er, ec,strg);
		int hw = 0; 
		hw+= MazePathTD(cr, cc+1, er, ec,strg);
		strg[cr][cc] = vw+hw;
		return hw+vw;
	}
	public static void MazePathBU(int cr,int cc,int er,int ec)
	{int [][] strg = new int[er+2][ec+2];
	 for(int r = er;r>=0; r--)
	 {
		 for(int c = ec; c>=0; c--)
		 {
			 if(r==er&&c==ec)
			 {
				 strg[r][c] = 1;
				 continue;
			 }
			 strg[r][c] = strg[r+1][c]+strg[r][c+1];
		 }
	 }
	 System.out.println(strg[0][0]);
		
	}
	public static void MazePathBUSE(int cr,int cc,int er,int ec)
	{int []strg = new int[er+1];
	 for(int i = 0; i<strg.length; i++)
	 {
		 strg[i] = 1;
	 }
	for(int i = 0; i<er;i++) { 
	 for(int r = strg.length-1;r>=0; r--)
	 {
		if(r==strg.length-1)
		{
			strg[r] = 1;
			continue;
		}
		strg[r] = strg[r]+strg[r+1];
			
	 }
	}
	 System.out.println(strg[0]);
		
	}
	public static int LCS(String s1,String s2)
	{
		if(s1.length()==0||s2.length()==0)
		{
			return 0;
		}
		
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		int ans = 0;
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if(ch1==ch2)
			ans = LCS(ros1,ros2)+1;
		else
		{
			int o1 = LCS(s1,ros2);
			int o2 = LCS(ros1,s2);
			ans = Math.max(o1, o2);
		}
		return ans;
		
	}
	public static int LCSTD(String s1,String s2,int[][]strg)
	{
		if(s1.length()==0||s2.length()==0)
		{
			return 0;
		}
		if(strg[s1.length()][s2.length()]!=-1)
			return strg[s1.length()][s2.length()];
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		int ans = 0;
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if(ch1==ch2)
			ans = LCSTD(ros1,ros2,strg)+1;
		else
		{
			int o1 = LCSTD(s1,ros2,strg);
			int o2 = LCSTD(ros1,s2,strg);
			ans = Math.max(o1, o2);
		}
		strg[s1.length()][s2.length()] = ans;
		return ans;
		
	}
	public static int LCSBU(String s1,String s2)
	{
		int [][] strg = new int[s1.length()+1][s2.length()+1];
		for(int r = s1.length()-1;r>=0;r--)
		{
			for(int c = s2.length()-1;c>=0; c--)
			{
				if(s1.charAt(r)==s2.charAt(c))
					strg[r][c] = strg[r+1][c+1]+1;
				else
				{
					strg[r][c] = Math.max(strg[r+1][c], strg[r][c+1]);
				}
			}
		}
		return strg[0][0];
	}
	public static int EditDistance(String s1,String s2)
	{
		if(s1.length()==0||s2.length()==0)
		{
			return Math.max(s1.length(), s2.length());
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		int ans = 0;
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if(ch1==ch2)
		{
			return EditDistance(ros1, ros2);
			
		}
		int in = EditDistance(ros1, s2);
		int d = EditDistance(s1, ros2);
		int r = EditDistance(ros1, ros2);
		ans = Math.min(in, Math.min(d, r))+1;
		return ans;
	}
	public static int EditDistanceTD(String s1,String s2,int[][]strg)
	{
		if(s1.length()==0||s2.length()==0)
		{
			return Math.max(s1.length(), s2.length());
		}
		if(strg[s1.length()][s2.length()]!=-1)
			return strg[s1.length()][s2.length()];
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		int ans = 0;
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if(ch1==ch2)
		{
			ans =  EditDistanceTD(ros1, ros2,strg);
			
		}
		else {
		int in = EditDistanceTD(ros1, s2,strg);
		int d = EditDistanceTD(s1, ros2,strg);
		int r = EditDistanceTD(ros1, ros2,strg);
		ans = Math.min(in, Math.min(d, r))+1;
		}
		strg[s1.length()][s2.length()] = ans;
		return ans;
	}
	public static int EditDistanceBU(String s1,String s2)
	{
		int [][] strg = new int[s1.length()+1][s2.length()+2];
		for(int r = s1.length();r>=0;r--)
		{
			for(int c = s2.length();c>=0;c--)
			{       
				if(r==s1.length())
				{
					strg[r][c] = s2.length()-c;
					continue;
				}
				if(c==s2.length())
				{
					strg[r][c] = s1.length()-r;
					continue;
				}
				if(s1.charAt(r)==s2.charAt(c))
				{
					strg[r][c] = strg[r+1][c+1];
				}
				else
				{
					strg[r][c] = Math.min(strg[r+1][c], Math.min(strg[r][c+1], strg[r+1][c+1]))+1;
				}
			}
		}
		return strg[0][0];
	}
	public static int chainmult(int []arr,int si,int ei)
	{
		if(si+1==ei)
			return 0;
		int min = Integer.MAX_VALUE;
		for(int k = si+1;k<=ei-1;k++)
		{
			int lp = chainmult(arr, si, k);
			int rp = chainmult(arr,k, ei);
			int sw = arr[si]*arr[ei]*arr[k];
			int total = lp+rp+sw;
			if(total<min)
				min = total;
		}
		return min;
	}
	public static int chainmultTD(int []arr,int si,int ei,int [][]strg)
	{
		if(si+1==ei)
			return 0;
		if(strg[si][ei]!=-1)
			return strg[si][ei];
		int min = Integer.MAX_VALUE;
		for(int k = si+1;k<=ei-1;k++)
		{
			int lp = chainmultTD(arr, si, k,strg);
			int rp = chainmultTD(arr,k, ei,strg);
			int sw = arr[si]*arr[ei]*arr[k];
			int total = lp+rp+sw;
			if(total<min)
				min = total;
		}
		strg[si][ei] = min;
		return min;
	}
	public static int chainmultBU(int[]arr)
	{
		int [][]strg = new int [arr.length][arr.length];
		int n = arr.length;
		for(int slide = 1;slide<=n-2; slide++)
		{
			for(int si = 0;si<=n-slide-2; si++)
			{
				int ei = si+slide+1;
				int min = Integer.MAX_VALUE;
				for(int k = si+1;k<=ei-1;k++)
				{
					int lp =strg[si][k];
					int rp = strg[k][ei];
					int sw = arr[si]*arr[ei]*arr[k];
					int total = lp+rp+sw;
					if(total<min)
						min = total;
				}
				strg[si][ei] = min;
			}
		}
		return strg[0][arr.length-1];
	}
	public static int wineprob(int []arr,int si,int ei,int yr)
	{
		if(si==ei)
			return arr[si]*yr;
		int first = wineprob(arr, si+1, ei, yr+1)+arr[si]*yr;
		int last = wineprob(arr, si, ei-1, yr+1)+arr[ei]*yr;
		int ans = Math.max(first, last);
		return ans;
	}
	public static int wineprobTD(int []arr,int si,int ei,int[][]strg)
	{
		int yr = arr.length-ei+si;
		if(si==ei)
			return arr[si]*yr;
		if(strg[si][ei]!=0)
			return strg[si][ei];
		int first = wineprobTD(arr, si+1, ei, strg)+arr[si]*yr;
		int last = wineprobTD(arr, si, ei-1, strg)+arr[ei]*yr;
		int ans = Math.max(first, last);
		strg[si][ei] = ans;
		return ans;
	}
	public static int wineprobBU(int []arr)
	{
		int n = arr.length;
		int [][]strg = new int[arr.length][arr.length];
		for(int slide = 0;slide<=n-1; slide++)
		{
			for(int si = 0; si<=n-slide-1;si++)
			{
				int ei = slide+si;
				int yr = n-ei+si;
				if(si==ei)
				{
					strg[si][ei] = arr[si]*yr;
					continue;
				}
				int first = strg[si+1][ei]+arr[si]*yr;
				int last = strg[si][ei-1]+arr[ei]*yr;
				int ans = Math.max(first, last);
				strg[si][ei] = ans;
			}
		}
		return strg[0][n-1];
	}
	public static boolean wildcard(String src,String pat)
	{
		if(src.length()==0&&pat.length()==0)
			return true;
		if(src.length()!=0&&pat.length()==0)
			return false;
		if(src.length()==0&&pat.length()!=0)
		{
			for(int i = 0;i<pat.length();i++)
			{
				if(pat.charAt(i)!='*')
					return false;
			}
			return true;
		}
		char chs = src.charAt(0);
		char chp = pat.charAt(0);
		String ros = src.substring(1);
		String rop = pat.substring(1);
		boolean ans = false;
		if(chs==chp||chp=='?')
		{
			ans = wildcard(ros, rop);
		}
		else if(chp=='*')
		{
			boolean blank = wildcard(src, rop);
			boolean multiple = wildcard(ros, pat);
			ans = blank||multiple;
		}
		else
		{
			ans = false;
		}
		return ans;
	}
	public static boolean wildcardTD(String src,String pat,int[][]strg)
	{
		if(strg[src.length()][pat.length()]!=0)
		{
			return strg[src.length()][pat.length()]==2?false:true;
		}
		if(src.length()==0&&pat.length()==0)
			return true;
		if(src.length()!=0&&pat.length()==0)
			return false;
		if(src.length()==0&&pat.length()!=0)
		{
			for(int i = 0;i<pat.length();i++)
			{
				if(pat.charAt(i)!='*')
					return false;
			}
			return true;
		}
		char chs = src.charAt(0);
		char chp = pat.charAt(0);
		String ros = src.substring(1);
		String rop = pat.substring(1);
		boolean ans = false;
		if(chs==chp||chp=='?')
		{
			ans = wildcard(ros, rop);
		}
		else if(chp=='*')
		{
			boolean blank = wildcardTD(src, rop,strg);
			boolean multiple = wildcardTD(ros, pat,strg);
			ans = blank||multiple;
		}
		else
		{
			ans = false;
		}
		strg[src.length()][pat.length()] = ans?1:2;
		return ans;
	}
	public static boolean wildcardBU(String src,String pat)
	{
		boolean[][] strg = new boolean[src.length()+1][pat.length()+1];
		strg[src.length()][pat.length()] = true;
		for(int row = src.length();row>=0; row--)
		{
			for(int col = pat.length()-1;col>=0;col--)
			{
				
				if(row==src.length())
				{
					if(pat.charAt(col)=='*')
					{
						strg[row][col] = strg[row][col+1];
						continue;
					}
					else
					{
						strg[row][col] = false;
						continue;
					}
				}
				char chs = src.charAt(row);
				char chp = pat.charAt(col);
				if(chs==chp||chp=='?')
				{
					strg[row][col] = strg[row+1][col+1];
				}
				else if(chp=='*')
				{
					boolean blank = strg[row][col+1];
					boolean multiple = strg[row+1][col];
					strg[row][col] = blank||multiple;
				}
				else
				{
					strg[row][col] = false;
				}
				
			}
		}
		return strg[0][0];
	}
	public static int knapsnack(int []wt,int []price,int vidx,int cap)
	{
		if(vidx==wt.length)
			return 0;
		 int include = 0;
		if(cap>=wt[vidx])
		  include = knapsnack(wt, price, vidx+1, cap-wt[vidx])+price[vidx];
		int exclude = knapsnack(wt, price, vidx+1, cap);
		int ans = Math.max(include, exclude);
		return ans;
	}
	public static int knapsnackTD(int []wt,int []price,int vidx,int cap,int [][]strg)
	{
		if(vidx==wt.length)
			return 0;
		if(strg[vidx][cap]!=0)
		{
			return strg[vidx][cap];
		}
		 int include = 0;
		if(cap>=wt[vidx])
		  include = knapsnackTD(wt, price, vidx+1, cap-wt[vidx],strg)+price[vidx];
		int exclude = knapsnackTD(wt, price, vidx+1, cap,strg);
		int ans = Math.max(include, exclude);
		strg[vidx][cap] = ans;
		return ans;
	}
	public static int knapsnackBU(int []wt,int[] price,int cap) 
	{
		int [][]strg = new int[wt.length+1][cap+1];
		for(int row = strg.length-2;row>=0; row--)
		{
			for(int col = 1;col<strg[0].length;col++)
			{
				 int include = 0;
					if(col>=wt[row])
					  include = strg[row+1][col-wt[row]]+price[row];
					int exclude = strg[row+1][col];
					int ans = Math.max(include, exclude);
					strg[row][col] = ans;
			}
		}
		return strg[0][cap];
	}
  public static int mixture(int []mix,int si,int ei)
  {
	  if(si==ei)
		  return 0;
	  int min = Integer.MAX_VALUE;
	  for(int k = si;k<=ei-1;k++)
	  {
		  int fp = mixture(mix, si, k);
		  int sp = mixture(mix,k+1, ei);
		  int sw = color(mix, si, k)*color(mix,k+1,ei);
		  int total = fp+sp+sw;
		  if(total<min)
			  min = total;
	  }
	  return min;
  }
  public static int mixtureTD(int []mix,int si,int ei,int[][]strg)
  {
	  if(si==ei)
		  return 0;
	  if(strg[si][ei]!=0)
		  return strg[si][ei];
	  int min = Integer.MAX_VALUE;
	  for(int k = si;k<=ei-1;k++)
	  {
		  int fp = mixtureTD(mix, si, k,strg);
		  int sp = mixtureTD(mix,k+1, ei,strg);
		  int sw = color(mix, si, k)*color(mix,k+1,ei);
		  int total = fp+sp+sw;
		  if(total<min)
			  min = total;
	  }
	  strg[si][ei] = min;
	  return min;
  }
  public static int color(int []mix,int si, int ei)
  {
	  int sum = 0;
	  for(int i = si; i<=ei; i++)
	  {
		  sum+=mix[i];
	  }
	  return sum%100;
  }
  public static int mixtureBU(int []mix)
  {
	  int n = mix.length;
	  int [][]strg = new int[mix.length][mix.length];
	  for(int slide = 1; slide<=n-1; slide++)
	  {
		  for(int si = 0; si<=n-slide-1; si++)
		  {
			  int ei = si+slide;
			  int min = Integer.MAX_VALUE;
			  for(int k = si;k<=ei-1;k++)
			  {
				  int fp = strg[si][k];
				  int sp = strg[k+1][ei];
				  int sw = color(mix, si, k)*color(mix,k+1,ei);
				  int total = fp+sp+sw;
				  if(total<min)
					  min = total;
				 
			  }
			  strg[si][ei] = min;
			  
		  }
	  }
//	  for (int i = 0; i < strg.length; i++) {
//		  for (int r = 0; r < strg[0].length; r++) {
//	         System.out.print(strg[i][r]+" ");
//		  }
//		  System.out.println();
//	  }
//		
	
	  return strg[0][mix.length-1];
  }
 public static int rodcut(int []arr,int len)
 {
	 int max = arr[len];
	 int left = 1;
	 int right = len - 1;
	 while(left<=right)
	 {
		 int fp = rodcut(arr, left);
		 int lp = rodcut(arr, right);
		 int total = fp+lp;
		 max = Math.max(total, max);
		 left++;
		 right--;
	 }
	 return max;
 }
 public static int rodcutTD(int []arr,int len,int []strg)
 {
	 if(strg[len]!=0)
		 return strg[len];
	 int max = arr[len];
	 int left = 1;
	 int right = len - 1;
	 while(left<=right)
	 {
		 int fp = rodcutTD(arr, left,strg);
		 int lp = rodcutTD(arr, right,strg);
		 int total = fp+lp;
		 max = Math.max(total, max);
		 left++;
		 right--;
	 }
	 strg[len] = max;
	 return max;
 }
 public static int rodcutBU(int []arr)
 {
	 int len = 1;
	 int []strg = new int[arr.length];
	 for(;len<strg.length; len++)
	 {
		 int max = arr[len];
		 int left = 1;
		 int right = len - 1;
		 while(left<=right)
		 {
			 int fp = strg[left];
			 int lp = strg[right];
			 int total = fp+lp;
			 max = Math.max(total, max);
			 left++;
			 right--;
		 }
		 strg[len] = max;
	 }
	 return strg[strg.length-1];
 }
 public static int palincuts(String str,int si,int ei)
 {
	 if(isPalindrome(str,si,ei))
		 return 0;
	 int min = Integer.MAX_VALUE;
	 for(int i = si; i<ei; i++)
	 {
		 int fp = palincuts(str, si, i);
		 int sp = palincuts(str, i+1, ei);
		 int total = fp+sp+1;
		 if(total<min)
			 min = total;
	 }
	 return min;
 }
 public static int palincutsTD(String str,int si,int ei,int[][]strg)
 {
	 if(isPalindrome(str,si,ei))
		 return 0;
	 if(strg[si][ei]!=0)
		 return strg[si][ei];
	 int min = Integer.MAX_VALUE;
	 for(int i = si; i<ei; i++)
	 {
		 int fp = palincutsTD(str, si, i,strg);
		 int sp = palincutsTD(str, i+1, ei,strg);
		 int total = fp+sp+1;
		 if(total<min)
			 min = total;
	 }
	 strg[si][ei] = min;
	 return min;
 }
 public static int palincutsBU(String str)
 {
	 int [][] strg = new int[str.length()][str.length()];
	 int n = str.length();
	 for(int slide = 0; slide<=n-1;slide++)
	 {
		 for(int si = 0; si<=n-slide-1; si++)
		 {
			 int ei = si+slide;
			 if(isPalindrome(str,si,ei))
			 {
				 strg[si][ei] = 0;
				 continue;
			 }
			 int min = Integer.MAX_VALUE;
			 for(int i = si; i<ei; i++)
			 {
				 int fp = strg[si][i];
				 int sp = strg[i+1][ei];
				 int total = fp+sp+1;
				 if(total<min)
					 min = total;
				 
			 }
			 strg[si][ei] = min;
		 }
	 }
	 return strg[0][str.length()-1];
 }
public static boolean isPalindrome(String str,int si,int ei) {
	int left = si;
	int right = ei;
	while(left<=right)
	{
		if(str.charAt(left)!=str.charAt(right))
			return false;
		left++;
		right--;
	}
	return true;
}
}

package practice;

public class stairs {

	public static void main(String[] args) {
//		ways(0,4);
//		System.out.println(count);
		//duplic("aabccba",0);
		//steps(4,1,0);
		int [] arr = {3,2,1};
		denom(4,0,arr);
		System.out.println(countw);
		
	}
	static int count = 0;
	static int countw = 0;
	public static void ways(int current, int end)
	{
		if(current==end)
		{
			count++;
			return;
		}
		if(current>end)
		{
			return ;
		}
		for(int step = 1; step<=3; step++)
		{
			ways(current+step,end);
		}
	}
	public static void duplic(String str,int ind)
	{
		StringBuilder st = new StringBuilder();
		st.append(str);
		if(ind==st.length())
		{
			System.out.println(st);
			return;
		}
		if(ind+1<st.length() && st.charAt(ind)==st.charAt(ind+1))
		{
			st.deleteCharAt(ind);
			String ans = st.toString();
			duplic(ans,ind+1);
		}
		else
		{
			String ans = st.toString();
			duplic(ans,ind+1);
		}
	}
	public static void steps(int current, int end,int counta)
	{
		if(current == end)
		{
			System.out.println(counta);
			return;
		}
		if(current<end)
		{
			return;
		}
		if(current%3==0)
		{
			steps(current/3,end,counta+1);
		}
		if(current%2==0)
		{
			steps(current/2,end,counta+1);
		}
		steps(current-1,end,counta+1);
	}
	public static void denom(int curr, int end, int[]arr)
	{
		if(curr==end)
			{
			  countw++;
			  return;
			}
		if(curr<end)
		{
			return;
		}
			
		for(int i=0;i<arr.length; i++)
		{
			denom(curr-arr[i],end,arr);
		}
	}
	}



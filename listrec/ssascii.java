package listrec;
import java.util.Scanner;
import java.util.ArrayList;
public class ssascii {

	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
//	 System.out.println(subse("abc"));
//	 System.out.println(keypad("145"));
//	 System.out.println(toss(3));
//	 System.out.println(perm("abc"));
//	 System.out.println(maze(0,0,2,2));
//	 System.out.println(board(0,10));
	 System.out.println(practice("1125"));

	}
	public static ArrayList<String> subse(String str)
	{
		if(str.length()==0)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		ArrayList<String> rr = subse(str.substring(1));
		ArrayList<String> mr = new ArrayList<>();
		for(String val:rr)
		{
			mr.add(val);
			mr.add(ch+val);
			mr.add((int)ch+val);
		}
		return mr;
		
	}
	public static String getCode(char ch)
	{
		if(ch=='1')
			return "abc";
		else if(ch=='2')
			return "def";
		else if(ch=='3')
			return "ghi";
		else if(ch=='4')
			return "jk";
		
		else if(ch=='5')
			return "lmno";
		else if(ch=='6')
			return "pqr";
		else if(ch=='7')
			return "stu";
		else if(ch=='8')
			return "vwx";
		else if(ch=='9')
			return "yz";
		else if(ch=='0')
			return "@#";
		else
			return "";
		
	}
	public static ArrayList<String> keypad(String str)
	{
		if(str.length()==0)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		ArrayList<String> rr = keypad(str.substring(1));
		String code = getCode(ch);
		ArrayList<String> mr = new ArrayList<>();
		for(int i = 0; i<code.length(); i++)
		{
			for(String val:rr)
			{
				mr.add(code.charAt(i)+val);
			}
		}
		return mr;
	}
	public static ArrayList<String> toss(int n)
	{
		if(n==0)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> rr = toss(n-1);
		ArrayList<String> mr = new ArrayList<>();
		for(String val:rr)
		{
			mr.add("H"+val);
			mr.add("T"+val);
		}
		return mr;
	}
	public static ArrayList<String> perm(String str)
	{
		if(str.length()==0)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		ArrayList<String> rr = perm(str.substring(1));
		ArrayList<String> mr = new ArrayList<>();
		for(String val:rr)
		{
			for(int i = 0; i<=val.length(); i++)
			{
				String ans = val.substring(0,i)+ch+val.substring(i);
				mr.add(ans);
			}
		}
		return mr;
	}
	public static ArrayList<String> maze(int cr, int cc, int er, int ec)
	{
		if(cr==er && cc==ec)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		if(cr+1<=er)
		{
			ArrayList<String> rrh = maze(cr+1,cc,er,ec);
			for(String val:rrh)
			{
				mr.add("V"+val);
			}
		}
		if(cc+1<=ec)
		{
			ArrayList<String> rrc = maze(cr,cc+1,er,ec);
			for(String val:rrc)
			{
				mr.add("H"+val);
			}
		}
		if(cr+1<=er&&cc+1<=ec)
		{
			ArrayList<String> rrd = maze(cr+1,cc+1,er,ec);
			for(String val:rrd)
			{
				mr.add("D"+val);
			}
		}
		return mr;
	}
	public static ArrayList<String>board(int curr, int end)
	{
		ArrayList<String> mr = new ArrayList<>();
		if(curr>end)
		{
			ArrayList<String> rr = new ArrayList<>();
			return rr;
		}
		if(curr==end)
		{
			ArrayList<String> rr = new ArrayList<>();
			rr.add("");
			return rr;
		}
		for(int dice = 1; dice<=6; dice++)
		{
			ArrayList<String> rrb = board(curr+dice,end);			
			
			for(String val:rrb)
			{
				mr.add(dice+val);
			}
		}
		return mr;
	}
	public static ArrayList<String> practice(String str)
	{
		if(str.length()==0)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		String ch = str.substring(0,1);
		ArrayList<String> rr = practice(str.substring(1));
		ArrayList<String> mr = new ArrayList<>();
		String code = (char)(Integer.parseInt(ch)+96)+""; 
		for(String val:rr)
		{
		  mr.add(code+val);
		}
		if(str.length()>=2)
		{
			String ch2 = str.substring(0,2);
			if(Integer.parseInt(ch2)<26)
			{
				
			 ArrayList<String> rra = practice(str.substring(2));
			 String code1 = (char)(Integer.parseInt(ch2)+96)+"";
			 for(String val:rra)
			{
				mr.add(code1+val);
			}
			}
		}
		return mr;
		
	}
}

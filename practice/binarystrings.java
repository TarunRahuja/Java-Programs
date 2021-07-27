package practice;
import java.util.*;
public class binarystrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z = 0; z<t; z++)
		{
			String str = sc.next();
			int nosp = 0;
			for(int i = 0; i<str.length(); i++)
			{
				if(str.charAt(i)=='?')
					nosp++;
			}
			ArrayList<String> mr = replace(str,nosp);
			System.out.println(mr);
		}

	}
	public static ArrayList<String> replace(String str,int nosp)
	{
		if(nosp==0)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add(str);
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = replace(str,nosp-1);
		for(int i = 0; i<rr.size(); i++)
		{
			if(i<rr.size()/2)
				
			{
				String val = rr.get(i);
				for(int j = 0; j<val.length(); j++)
			{
				if(val.charAt(j)=='?')
				{
				  mr.add(val.substring(0,i)+"0"+val.substring(i+1));
				}
			}
			}
			else if(i>rr.size()/2)
				
			{
				String val = rr.get(i);
				for(int j = 0; j<val.length(); j++)
			{
				if(val.charAt(j)=='?')
				{
				  mr.add(val.substring(0,i)+"1"+val.substring(i+1));
				}
			}
			}
		}
		return mr;
		
	}

}

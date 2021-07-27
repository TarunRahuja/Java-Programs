package practice;
import java.util.ArrayList;
public class codesofstring {

	public static void main(String[] args) 
	{
	  	System.out.println(codes("1125"));
	}
	public static ArrayList<String> codes(String str)
	{
			if(str.length()==0)
			{
				ArrayList<String> br = new ArrayList<>();
				br.add("");
				return br;
			}
			char ch = (Integer.parseInt(str.charAt(0)+"")+"").charAt(0);
			ArrayList<String> rr = codes(str.substring(1));
			ArrayList<String> mr = new ArrayList<>();
			for(String val:rr)
			{
				mr.add((char)((int)ch+97)+val);
			}
			return mr;
		}

}

package practice;
import java.util.ArrayList;
public class partition {

	public static void main(String[] args) {
//		ArrayList<String> mr = partition(0,4);
//		boolean flag = false;
//		for(String val:mr)
//		{
//			for(int i = 0; i<val.length()-1; i++)
//			{
//				if(val.charAt(i)>val.charAt(i+1))
//	               flag = true;
//			}
//			if(flag)
//			{
//				mr.remove(val);
//			}
//		}
		System.out.println(partition(0,4));
	}
	public static ArrayList<String> partition(int current, int end)
	{
		if(current==end)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if(current>end)
		{
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		for(int add = 1; add<end ;add++)
		{
			ArrayList<String> rr = partition(current + add, end);
			for(String val:rr)
			{
				//if(Integer.parseInt(add+"")<=Integer.parseInt(val.charAt(0)+""))
				  mr.add(add+val);
			}
		}
		return mr;
	}

}

package practice;
import java.util.*;
public class dictionary {
    static ArrayList<String> mr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		permduplic(str,"");
		ArrayList<String> fr = new ArrayList<>();
		int flag = 0;
		for(int m = 0; m<mr.size(); m++)
		{
			String val = mr.get(m);
			flag = 0;
			for(int i = 0; i<str.length(); i++)
			{
				if(val.charAt(i)!=str.charAt(i))
				{
					if(val.charAt(i)>str.charAt(i))
					{
						flag = 1;
						break;
					}
					else
					{
						flag = 0;
						break;
					}
				
				}
			}
			if(flag==1)
				fr.add(val);
		}
		for(String val1:fr)
		{
			System.out.println(val1);
		}
	}
	 public static void permduplic(String ques, String ans)
	  {
		  if(ques.length()==0)
			{
				mr.add(ans);
			    //System.out.print(ans+" ");
				return;
			}
			for(int i = 0; i<ques.length(); i++)
			{
				String newques = ques.substring(0,i)+ques.substring(i+1);
				char ch = ques.charAt(i);
				int flag = 0;
				for(int j = i+1; j<ques.length(); j++)
				{
					if(ques.charAt(j)==ch)
					{
						flag = 1;
					}
				}
				if(flag==0)
			      permduplic(newques,ans+ques.charAt(i));
			}	
	  }

}

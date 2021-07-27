package practice;
import java.util.Scanner;
public class disequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String [] arr = new String[n];
		for(int i = 0; i<n; i++)
		{
			arr[i] = sc.next();
		}
		String ans = "";
		for(int i = 0; i<arr.length ; i++)
		{
			String ques = arr[i];
			if(ques.charAt(0)=='D')
			{
				ans = "21";
			}
			if(ques.charAt(0)=='I')
			{
				ans = "12";
			}
			for(int j = 1; j<ques.length(); j++)
			{
					
				if(ques.charAt(j)=='D')
				{
					boolean alloted = false;
					int k = 1;
					while(!alloted)
					{
						String str = Integer.parseInt(ans.charAt(ans.length()-1)+"")-k+"";
						if(!isfound(ans,str.charAt(0))&&(Integer.parseInt(str.substring(0,1))>0))
						{ ans = ans+(Integer.parseInt(ans.charAt(ans.length()-1)+"")-k);
						  alloted = true;
						}
						else
							k++;
					}
					
				}
				if(ques.charAt(j)=='I')
				{
					boolean alloted = false;
					int k = 1;
					while(!alloted)
					{
						String str = Integer.parseInt(ans.charAt(ans.length()-1)+"")+k+"";
						if(!isfound(ans,str.charAt(0))&&(Integer.parseInt(str.substring(0,1))<=9))
						{ ans = ans+(Integer.parseInt(ans.charAt(ans.length()-1)+"")+k);
						  alloted = true;
						}
						else
							k++;
					}
				}
			}
			System.out.println(ans);
		}
		

	}
	public static boolean isfound(String ans,char ch)
	{
		for(int i = 0; i<ans.length(); i++)
		{
			if(ch==ans.charAt(i))
				return true;
		}
		return false;
	}

}

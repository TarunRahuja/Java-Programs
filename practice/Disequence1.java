package practice;
import java.util.*;
public class Disequence1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int t = 0; t<n; t++)
		{
			String str = sc.next();
			int []ans = new int[str.length()+1];
			int count = 1;
			for(int i = 0; i<=str.length(); i++)
			{
				if(i==str.length()||str.charAt(i)=='I')
				{
					ans[i] = count; 
					count++;
					for(int j = i-1; j>=0&&str.charAt(j)!='I'; j--)
					{
						ans[j] = count++;
					}
				}
			}
			for(int i = 0; i<ans.length; i++)
			 {
				System.out.print(ans[i]);
			 }
			System.out.println();
			 }
		}

	}



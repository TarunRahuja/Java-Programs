package practice;
import java.util.*;
public class GenerateSorted {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] one = new int[n];
		int m = sc.nextInt();
		int []two = new int[m];
		for(int i = 0; i<n; i++) {
			one[i] = sc.nextInt();
		}
		for(int i = 0; i<m ; i++)
		{
			two[i] = sc.nextInt();
		}
		generate(one, two, 0, 0, "", true);
		

	}
	public static void generate(int []one, int[]two, int i, int j,String ans, boolean isa)
	{
		if(i==one.length||j==two.length)
			return;
		if(isa&&ans!="")
			System.out.println(ans);
		if(i<one.length&&isa)
		{
			if(one[i]>two[j])
				generate(one, two, i, j,ans+one[i], false);
			   
			else
				i++;
		}
		if(j<two.length&&!isa)
		{
			if(two[j]>one[i])
				generate(one, two, i, j, ans+two[j], true);
			else
				j++;
		}
	}
	

}

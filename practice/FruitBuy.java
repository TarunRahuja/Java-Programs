package practice;
import java.util.*;
public class FruitBuy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int [][]prices = new int[n][3];
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<3; j++)
				{
					prices[i][j] = sc.nextInt();
				}
			}
			int ans = minimum(prices, 0, 0, -1);
			System.out.println(ans);
		}

	}
	public static int minimum(int [][]prices,int vidx,int price,int lastidx)
	{
		int min = Integer.MAX_VALUE;
		if(vidx==prices.length)
		{
			return Integer.MAX_VALUE;
		}
		
		for(int currentidx = 0; currentidx<3;currentidx++)
		{
			if(currentidx==lastidx)
				continue;
			price+=prices[vidx][currentidx];
			int val = minimum(prices, vidx+1, price, currentidx);
			if(price<val)
				min = price;
		}
		return min;
	}

}

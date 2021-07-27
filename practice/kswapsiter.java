package practice;
import java.util.*;
public class kswapsiter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String num = n + "";
        int [] arr = new int[num.length()];
        for(int i = 0; i<num.length(); i++)
        {
        	arr[i] = Integer.parseInt(num.substring(i,i+1));
        }
        int i = 0;
        while(i+1<arr.length&&k>0)
        {
        	if(arr[i]<arr[i+1])
        	{
        		int temp = arr[i];
    			arr[i] = arr[i+1];
    			arr[i+1] = temp;
    			k--;
        	}
        }
        for(i = 0; i<arr.length; i++)
		{
			System.out.print(arr[i]);
		}

	}

}

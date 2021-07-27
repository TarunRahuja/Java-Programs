package arraylist;
import java.util.Scanner;
public class strings1 {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(palindrome(str));
		substr(str);
		int count  = subpal(str);
		System.out.println(count);
	}
	public static boolean palindrome(String str) {
		int length = str.length();
		for(int i = 0; i<length/2; i++)
		{
			if(str.charAt(i)!=str.charAt(length-i-1))
			{
				return false;
			}
		}
		return true;
	}
	
    public static void substr(String str)
    {
    	int len = str.length();
    	for(int si = 0; si<len; si++)
    	{
    		for(int ei=si+1; ei<=len; ei++)
    		{
    			System.out.println(str.substring(si,ei));
    		}
    	}
    }
    public static int subpal(String str)
    {
    	int len = str.length();
    	int count = 0;
    	for(int si = 0; si<len; si++)
    	{
    		for(int ei=si+1; ei<=len; ei++)
    		{
    			boolean res = palindrome(str.substring(si,ei));
    			if(res)
    			{
    				count++;
    			}
    				
    		}
    	}
    	//System.out.println(count);
    	return count;
    }
}

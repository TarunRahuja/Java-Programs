package arraylist;
import java.util.ArrayList;
public class arraylist {

	public static void main(String[] args) {
		//ArrayList<Integer> list1 = new ArrayList<>();
		int [] one = {10,10,20,30,30,40,50,50,50,70};
		int [] two = {10,20,20,20,20,30,45,50,50,80,90};
		System.out.println(intersection(one,two));
		System.out.println(addition(one,two));

	}
	public static ArrayList<Integer> intersection(int[] one, int[] two)
	{
		ArrayList<Integer> ans = new ArrayList<>();
		int j = 0;
		int i = 0;
	 while(i<one.length&&j<two.length)
		{
			if(one[i]>two[j])
				j++;
			
			else if(one[i]==two[j])
					{ ans.add(one[i]);
					 j++;
					 i++;
				    }
			else
				i++;		
		}
		return ans;
		
	}
	public static ArrayList<Integer> addition(int []one, int []two)
	{
		int i = one.length-1;
		int j = two.length-1;
		ArrayList<Integer> ans = new ArrayList<>();
		int carry = 0;
		int sum = 0;
		while(j>=0 || i>=0)
		{
			sum+=carry;
			if(i>=0)
			{
				sum+= one[i];
				i--;
			}
			if(j>=0)
			{
				sum+=two[j];
				j--;
			}
			int rem = sum%10;
			ans.add(0,rem);
			carry = sum/10;
		}
  if(carry!=0)
	  ans.add(0,carry);
		return ans;
		
		
	}

}

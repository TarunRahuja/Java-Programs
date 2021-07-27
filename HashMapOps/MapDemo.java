package HashMapOps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class MapDemo {

	public static void main(String[] args) {
	  String str = "aaabbccccaa";
	  HashMap<Character,Integer> map = new HashMap<>();
	  for(int i = 0;i<str.length();i++)
	  {
		  char ch = str.charAt(i);
		  if(map.containsKey(ch))
		  {
			  int val = map.get(ch);
			  map.put(ch,val+1);
		  }
		  else
		  {
			  map.put(ch,1);
		  }
	  }
	  
	  //System.out.println(map);
	  int max = Integer.MIN_VALUE;
	  Character maxchar = 0;
	  for(Character ch: map.keySet())
	  {
		  int freq = map.get(ch);
		  if(freq>max)
		  {
			  max = freq;
			  maxchar = ch;
		  }
	  }
//	  System.out.println(maxchar);
//	  int [] one = {10,10,20,30,30};
//	  int [] two = {10,20,30,30};
//	  System.out.println(intersection(one, two));
//	  int [] arr = {2,12,9,16,10,5,3,20,25,11,1,8,6};
//	  sequence(arr);
	  practice();
	}
	public static void practice()
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		HashMap<Integer,Integer> map1 = new HashMap<>();
		for(int i = 0; i<10; i++) {
			map.put(i, i);
		}
		for(int i = 0; i<10; i++) {
			map1.put(i,i);
		}
		ArrayList<Integer> maplist = new ArrayList<>(map.keySet());
		ArrayList<Integer> maplist1 = new ArrayList<>(map1.keySet());
		int j = 0;
		int k=0;
		for(;k<maplist.size()&&j<maplist1.size(); k++,j++) {
			System.out.println(map1.get(maplist1.get(k)));
			System.out.println(map.get(maplist.get(j)));
		}
	}
	public static ArrayList<Integer> intersection(int[]one,int []two)
	{
	  HashMap<Integer,Integer> map = new HashMap<>();
	  ArrayList<Integer> ans = new ArrayList<>();
	  for(int i = 0; i<one.length; i++)
	  {
		  if(map.containsKey(one[i]))
		  {
			  map.put(one[i], map.get(one[i])+1);
		  }
		  else
		  {
			  map.put(one[i],1);
		  }
	  }
	  for(int j = 0; j<two.length; j++)
	  {
		  if(map.containsKey(two[j]))
		  {
			  ans.add(two[j]);
			  map.put(two[j], map.get(two[j])-1);
			  if(map.get(two[j])==0)
			  {
				  map.remove(two[j]);
			  }
		  }
	  }
	  return ans;
	}
	public static void sequence(int[] arr) {
		HashMap<Integer,Boolean> map = new HashMap<>();
		for(int i = 0;i<arr.length; i++)
		{
			if(map.containsKey(arr[i]-1))
			{
				map.put(arr[i],false);
			}
			else
			{
				map.put(arr[i], true);
				if(map.containsKey(arr[i]+1))
				{
					map.put(arr[i]+1,false);
				}
			}
		}
		int count = 0;
		int max = -1;
		int si = 0;
		for(int val:map.keySet())
		{
			if(map.get(val))
			{
			    count = 0;
				while(map.containsKey(val+count))
				{
					count++;
				}
				if(count>max)
				{
					max = count;
					si = val;
				}
			}
		}
		for(int i = 0; i<max; i++)
		{
			System.out.print(si+i+" ");
		}
	}
}

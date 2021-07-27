package practice;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> prime = new ArrayList<>();
		//int q = 7;
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(30);
		q.add(10);
		q.add(20);
		//q.remove();
		System.out.println(q.peek());
//		for(int i = 2; count<q; i++)
//        {
//            if(isprime(i))
//              {
//                  count++;
//                  prime.add(i);
//              }
//        }
//		System.out.println(prime);

	}

	private static boolean isprime(int n) {
		 if(n==2)
		      return true;
		    for(int i = 2; i<n; i++)
		    {
		        if(n%i==0)
		         return false;
		    }
		    return true;
		
	
	}

}

package recursion;
import java.util.*;
class AlternatingArrays {
	public static void main (String[] args) {
		int [] a = new int[]{10,15,25};
		int [] b = new int[]{1,5,20,30};
		helper(a,b,0,0,0,new ArrayList<>());
	}
	static void helper(int []a, int []b, int i, int j, int turn, ArrayList<Integer> subset){
	    if(i == a.length && turn == 0){
	        if(subset.size() > 0)
	          System.out.println(subset);
	        return;
	    }
	    if(j == b.length && turn == 1){
	        return;
	    }
	    int prev = subset.size() == 0 ? -999999 : subset.get(subset.size()-1);
	    if(turn == 0){
	        if(a[i] > prev){
	            subset.add(a[i]);
	            helper(a,b,i+1,j,turn^1,subset);
	            subset.remove(subset.size()-1);
	        }
	        helper(a,b,i+1,j,turn,subset);
	    }
	    else{
	        if(b[j] > prev){
	            subset.add(b[j]);
	            helper(a,b,i,j+1,turn^1,subset);
	            subset.remove(subset.size()-1);
	        }
	        helper(a,b,i,j+1,turn,subset);
	    }
	}
}
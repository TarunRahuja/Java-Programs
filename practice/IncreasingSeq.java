package practice;
import java.util.*;
public class IncreasingSeq {
	static ArrayList<String> mr = new ArrayList<>();
	public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int [] arr = new int[n];
     for(int i=0; i<n; i++)
     {
    	 arr[i] = i+1;
     }
     int k = sc.nextInt();
     incseq(arr,0, "", k);
     for(String val:mr)
     {
    	 if(val.length()==k)
    		 System.out.println(val);
     }
    // System.out.println(mr);
	}
	public static void incseq(int []arr, int vidx, String ans,int k)
	{
		if(vidx==arr.length) {
			//System.out.println(ans);
			mr.add(ans);
			return;
		}
		incseq(arr, vidx+1, ans+arr[vidx]+" ", k);
		incseq(arr, vidx+1, ans, k);
	}

}

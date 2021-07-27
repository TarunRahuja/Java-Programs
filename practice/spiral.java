package practice;
import java.util.*;
public class spiral {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>>ans=generateMatrix1(3);
        System.out.println(ans);
	}
	public static ArrayList<ArrayList<Integer>> generateMatrix(int n)
	{
	        int [][] arr = new int[n][n];
	        int minrow = 0,maxrow = n-1,mincol = 0,maxcol = n-1;
	        int nst = 0;
	        int tot = n*n;
	        int count = 1;
	        while(nst<tot)
	        {
	            for(int i = mincol; i<=maxcol&&nst<tot;i++)
	            {
	            	//System.out.println(i+" "+ minrow);
	                arr[minrow][i] = count++;
	                System.out.println("row = "+minrow+" col =  "+ i+ " value = "+arr[minrow][i]);
	                nst++;
	            }
	            minrow++;
	            for(int i = minrow; i<=maxrow&&nst<tot; i++)
	            {
	            	//System.out.println(i+" "+ maxcol);
	            	arr[i][maxcol] = count++;
	            	System.out.println("row = "+i+" col =  "+ maxcol+ " value = "+arr[i][maxcol]);
	                nst++;
	            }
	            maxcol--;
	            for(int i = maxcol; i>=mincol&&nst<tot; i--)
	            {
	                arr[maxrow][i] = count++;
	                System.out.println("row = "+maxrow+" col =  "+ i+ " value = "+arr[maxrow][i]);
	                nst++;
	            }
	            maxrow--;
	            for(int i = maxrow; i>=minrow&&nst<tot; i--)
	            {
	                arr[i][mincol] = count++;
	                System.out.println("row = "+mincol+" col =  "+ i+ " value = "+arr[mincol][i]);
	                nst++;
	            }
	            mincol++;
	        }
	        for(int i = 0; i<arr.length; i++)
	        {
	            for(int j = 0; j<arr[0].length; j++)
	            {
	                System.out.print(arr[i][j]+" ");
	            }
	           System.out.println();
	        }
	        ArrayList<ArrayList<Integer>> finalans = new ArrayList<>();
	        ArrayList<Integer> ans = new ArrayList<>();
	        for(int i = 0; i<arr.length; i++)
	        {
	            for(int j = 0; j<arr[0].length; j++)
	            {
	                ans.add(arr[i][j]);
	            }
	            finalans.add(ans);
	            ans = new ArrayList<>();
	        }
	        return finalans;
	    }
	
	public static ArrayList<ArrayList<Integer>> generateMatrix1(int n) {
        int [][] arr = new int[n][n];
        int minrow = 0,maxrow = n-1,mincol = 0,maxcol = n-1;
        int nst = 0;
        int tot = n*n;
        int count = 1;
        while(nst<tot)
        {
            for(int i = mincol; i<=maxcol&&nst<tot;i++)
          {
                arr[minrow][i] = count++;
                nst++;
            }
            minrow++;
            for(int i = minrow; i<=maxrow&&nst<tot; i++)
            {
     
 arr[i][maxcol] = count++;
             nst++;
            }
            maxcol--;
            for(int i = maxcol; i>=mincol&&nst<=tot; i--)
            {
                arr[maxrow][i] = count++;
                nst++;
            }
            maxrow--;
            for(int i = maxrow; i>=minrow&&nst<=tot; i--)
            {
                arr[i][mincol] = count++;
                nst++;
            }
            mincol++;
        }
        ArrayList<ArrayList<Integer>> finalans = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j<arr[0].length; j++)
            {
                ans.add(arr[i][j]);
            }
            finalans.add(ans);
            ans = new ArrayList<>();
        }
        return finalans;
    }
}

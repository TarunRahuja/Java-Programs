package practice;

import java.util.*;
public class cows {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) 
    {
     int n = sc.nextInt();
     int [] arr = new int[n];
     int c = sc.nextInt();
     for(int i = 0; i<n; i++)
     {
         arr[i] = sc.nextInt();
     }
     for(int i = 0; i<n-1; i++)
     {
         for(int j = 0; j<n-1-i; j++)
         {
             if(arr[j]>arr[j+1])
             {
                 int temp = arr[j];
                 arr[j] = arr[j+1];
                 arr[j+1] = temp;
             }
         }
     }
     int lo = 0;
     int hi = arr[n-1]-arr[0];
     int ans = 0;
     while(lo<=hi)
     {
         int mid = (lo+hi)/2;
         if(fun(mid,arr,c))
         {
//        	 System.out.println(fun(mid,arr,c));
             lo = mid+1;
             ans = mid;
         }
         else
          hi = mid-1;
     }
     System.out.println(ans);
    }
    public static boolean fun(int mid, int[] arr, int C)
    {
        int n = arr.length;
        int i = 0,j = 0;
        int c = 1;
        while(i<n)
        {
            j = i+1;
            while(j<n)
//            {   System.out.print(i+" "+j);
//                System.out.println();
            {
            	if(arr[j]-arr[i]>=mid)
                {
                    c++;
//                    i = j;
                    break;
                }
                else
                 j++;
            
            }
            i = j;
        }
        if(c>=C)
          return true;
        else 
          return false;
    }
    
    
}
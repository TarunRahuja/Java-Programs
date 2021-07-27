package practice;
import java.util.Scanner;
public class painter {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();                                 
        int []arr = new int[n];
        for(int i = 0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i<n-1; i++)
        {
            for(int j = 0; j<n-1-i; j++)
            {
                if(arr[j+1]<arr[j])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                }
            }
        }
        int lo = arr[n-1];
        int sum = 0;
        for(int i = 0; i<n; i++)
        {
            sum+=arr[i]; 
        }
        int hi = sum;
        int ans = 0;
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            if(fun(mid,arr,k))
            {
                ans = mid;
                hi = mid-1;
            }
            else
            {
                lo = mid+1;
            }
        }
        System.out.println(ans);
    }
    public static boolean fun(int mid, int[]arr, int k)
    {
        int sum = 0;
        int n = arr.length;
        int c = 1;
        int i = 0;
       while(i<n)
       {
    	 if(sum<=mid)
    	 {
    		 sum+=arr[i];
    		 i++;
    	 }
    	 else
    	 {
    		 sum = 0;
    		 c++;
    	 }
    	
       }
         if(c<=k)
          return true;
        else
          return false;
    }

}



package practice;
import java.util.*;
public class nextgreater
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int z = 0; z<t; z++)
        {
            int n = sc.nextInt();
            int [] arr = new int[n+1];
            for(int i = 0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i<n; i++)
            {
                int j = i+1;
                while(j<=n && arr[j]<=arr[i])
                {
                    j++;
                }
                if(j<=n-1)
                {
                    int k = j+1;
                    while(k<=n && arr[k]>=arr[j])
                    {
                        k++;
                    }
                    if(k<n)
                     System.out.print(arr[k]+" ");
                     if(k==n)
                      System.out.print(-1+" ");
                }
                if(j>=n)
                {
                 System.out.print(-1+" ");   
                }
                }
            }
        }

    }


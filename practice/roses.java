package practice;
import java.util.Scanner;
public class roses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int p = 0; p<t; p++)
        {
            int n = sc.nextInt();
            int []arr = new int[n];
            for(int i = 0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            for(int i = 0; i<n-1;i++)
            {
                for(int j = 0; j<n-1-i;j++)
                {
                    if(arr[j]>arr[j+1])
                     {
                         int temp = arr[j];
                         arr[j] = arr[j+1];
                         arr[j+1] = temp;
                     }
                }
            }
            int j = 0;
            int flag = 0;
            int init = 0;
            int fin = 0;
            int min = 1000001;
            int dif = 1000001;
            for(int i = 0; i<n-1; i++)
            {
                flag = 0;
                for(int k= i+1; k<n; k++)
                {
                    if(arr[i]+arr[k]==m)
                      {
                          j = k;
                          flag = 1;
                      }
                      if(flag==0)
                       dif = 1000001;
                      else
                        dif = Math.abs(arr[j]-arr[i]);
                }
                if(dif<min)
               { init = i;
                 fin = j;
                 min = dif;
               }
            }
             System.out.println("Deepak should buy roses whose prices are "+arr[init]+" and "+arr[fin]+".");
        }

	}

}

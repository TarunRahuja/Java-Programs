package reverseArray;
import java.util.Scanner;
public class SubsetArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		int lim = (int)Math.pow(2,arr.length);
		for(int i = 0; i<lim;i++)
		{
			int temp = i;
			
			for(int c=0;c<arr.length;c++)
			{
				int rem = temp%2;
				if(rem==1)
				{
					System.out.print(arr[c]+"  ");
				}
				temp/=2;
			}
			System.out.println();
		}
		
		}

	}



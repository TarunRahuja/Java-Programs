package twoDArray;
import java.util.Scanner;
public class basicops {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
//		int row = sc.nextInt();
//		int col = sc.nextInt();
//		int [][] arr = new int[row][col];
		//arr = input(arr);
		int [][]arr = {{1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};
		//display(arr);
		//vertdisp(arr);
		//wavdisp(arr);
		//spirdisp(arr);
		multiply(arr);
		

	}
	public static int[][] input(int [][] arr)
	{
		for(int i = 0; i<arr.length; i++)
		{
			for(int j = 0; j< arr[0].length; j++)
			{
				System.out.println("["+i+"]"+"["+j + "]");
				arr[i][j] = sc.nextInt();
			}
		}
		return arr;
	}

	public static void display(int [][] arr)
	{
		for(int i = 0; i<arr.length; i++)
		{
			for(int j = 0; j< arr[0].length; j++)
			{
				System.out.println("["+i+"]"+"["+j + "]" + "=" + arr[i][j]);
				
			}
			System.out.println();
		}
		
	}
	public static void vertdisp(int [][]arr)
	{
		for(int col= 0; col<arr[0].length;col++)
		{
			for(int row = 0;row<arr.length;row++)
			{
				System.out.println("["+row+"]"+"["+col + "]" + "=" + arr[row][col]);
			}
		}
	}
	public static void wavdisp(int [][]arr)
	{
		
		for(int col= 0; col<arr[0].length;col++)
		{
		  if(col%2==0)	
			{
			  for(int row = 0;row<arr.length;row++)
			{
				System.out.println("["+row+"]"+"["+col + "]" + "=" + arr[row][col]);
			}
			  
			}
		  else
		  {
			  for(int row = arr.length-1;row>=0;row--)
				{
					System.out.println("["+row+"]"+"["+col + "]" + "=" + arr[row][col]);
				}

		  }
		}
		
	}
	public static void spirdisp(int [][]arr)
	{
		int minr = 0,maxr = arr.length-1, minc = 0, maxc = arr[0].length-1;
		int count = 0;
		int tot = arr.length * arr[0].length;
		while(count<tot)
		{
			for(int row = minr; row<=maxr && count<tot; row++)
			{
				System.out.println("["+row+"]"+"["+minc + "]" + "=" + arr[row][minc]);
				count++;
			}
			minc++;
			for(int col = minc; col<=maxc && count<tot; col++)
			{
				System.out.println("["+maxr+"]"+"["+col + "]" + "=" + arr[maxr][col]);
				count++;
			}
			
			maxr--;
			for(int row = maxr; row>=minr && count<tot; row--)
			{
				System.out.println("["+row+"]"+"["+maxc+ "]" + "=" + arr[row][maxc]);
				count++;
			}
			maxc--;
			for(int col = maxc; col>=minc && count<tot; col--)
			{
				System.out.println("["+minr+"]"+"["+col + "]" + "=" + arr[minr][col]);
				count++;
			}
			minr++;
		}
		
	}
	public static void multiply(int [][]arr)
	{
		int [][] mult = new int[arr.length][arr[0].length];
		for(int i = 0; i<arr.length; i++)
		{
			for(int j = 0; j<arr[0].length; j++)
			{
				for(int k = 0; k< arr[0].length; k++)
				{
					mult[i][j]+= arr[i][k]*arr[k][j]; 
				}
			}
		}
		for(int i = 0; i<mult.length; i++)
		{
			for(int j = 0; j< mult[0].length; j++)
			{
				System.out.println("["+i+"]"+"["+j + "]" + "=" + mult[i][j]);
				
			}
			System.out.println();
		}
		
	}
}

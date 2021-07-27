package practice;
import java.util.*;
public class Sudoku {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int [][]sudo = new int[n][n];
	        for(int row = 0; row<n; row++)
	        {
	            for(int col = 0; col<n; col++)
	            {
	                sudo[row][col] = sc.nextInt();
	            }
	        }
	        sudofill(sudo,0,0);

	}
	public static void sudofill(int[][]sudo, int row, int col)
	{
		if(col==sudo[0].length)
		{
			row++;
			col = 0;
		}
		if(row==sudo.length)
		{
			for(int r = 0; r<sudo.length; r++)
			{
				for(int c = 0; c<sudo[0].length; c++)
				{
					System.out.print(sudo[r][c]+" ");
				}
				System.out.println();
			}
			return;
		}
		if(sudo[row][col]!=0)
			{
			    sudofill(sudo, row, col+1);
			    return;
			}   
		for(int i = 1; i<=9; i++)
		{  
			if(isitsafe(sudo, row, col, i))
			{
			  sudo[row][col] = i;
			  sudofill(sudo, row, col+1);
			  sudo[row][col] = 0;
			}
		}
	}
	public static boolean isitsafe(int[][]sudo, int row, int col, int i)
	{
		int r = row;
		int c = 0;
		while(c<sudo[0].length)
		{
			if(sudo[r][c]==i)
				return false;
			c++;
		}
		r = 0; 
		c = col;
		while(r<sudo.length)
		{
			if(sudo[r][c]==i)
				return false;
			r++;	
		}
		

		for(r = row-(row%3);r<r+3;r++)
		{
			for(c = col-(col%3);c<c+3;c++)
			{
				if(sudo[r][c]==i)
					return false;
			}
		}
		return true;
		
	}

}

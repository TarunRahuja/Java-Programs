package practice;

import java.util.Scanner;

public class chessboard2 {

	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		int val = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = val++;
			}
		}
		int primec = 1;
		int [][] minport = new int[n][n];
		for(int i = 0; i<n; i++)
		{	
			for(int j = 0; j<n; j++)
			{
				if(isprime(board[i][j]))
				{
					minport[i][j] = primec++; 
				}
			}
		}

       

		chess(board, 0, 0, "", minport);
		System.out.println();
		System.out.print(count);
	}

	public static void chess(int[][] board, int col, int row, String ans, int[][] minport) {

		if (col == board[0].length - 1 && row == board.length - 1) {
			System.out.print(ans + "{" + (row) + "-" + (col) + "}" + " ");
			count++;
			return;
		}
		if (row >= board.length || col >= board[0].length) {
			return;
		}
		boolean isPrime = isprime(board[row][col]);
		if(isPrime&& minport[row][col]%2!=0) 
		{
			return;
		}
		
		if (isPrime && minport[row][col]%2==0) {
			chess(board, board[0].length - 1, board.length - 1, ans + "{" + (row) + "-" + (col) + "}" + "P", minport);
		
		}
		chess(board, col + 1, row + 2, ans + "{" + (row) + "-" + (col) + "}" + "K", minport);
		chess(board, col + 2, row + 1, ans + "{" + (row) + "-" + (col) + "}" + "K", minport);

		if (row == 0 || col == 0 || row == board.length - 1 || col == board[0].length - 1) 
		{
			for (int i = 1; i + col < board[0].length; i++)
			{
				chess(board, col + i, row, ans + "{" + (row) + "-" + (col) + "}" + "R", minport);
			}

			for (int i = 1; i + row < board.length; i++)
			{
				chess(board, col, row + i, ans + "{" + (row) + "-" + (col) + "}" + "R", minport);
			}
		}

		if (row == col || row + col == board.length - 1)
		{
			for (int i = 1; i + col < board[0].length && i + row < board.length; i++)
			{
				chess(board, col + i, row + i, ans + "{" + (row) + "-" + (col) + "}" + "B", minport);
			}
		}

	}

	public static boolean isprime(int num) {
		if (num == 1)
			return false;
		if (num == 2)
			return true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}

		}
		return true;
	}
}

package printrec;

import java.util.*;

public class printsub {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// String word = sc.next();
//		char [][] crossword = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','F'}};
//		boolean ans = false;
//		for(int i = 0; i<crossword.length; i++)
//		{
//			for(int j = 0; j<crossword[0].length; j++)
//			{
//				if(crossword[i][j]==word.charAt(0))
//				{
//					ans = ans||wordsearch(crossword, i, j, word, 0, new boolean [crossword.length][crossword[0].length]);
//				
//				}
//			}
//		}
		int [][]paths = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
		System.out.println(solve(paths));
		// System.out.println(ans);
		// printss("abc","");
		// keypad("145","");
//		 perm2("abc","");
//		 perm("abc","");
		// paran(2,"",0,0);
//		board(0,10,"");
//		maze(0,0,2,2,"");
//		permduplic("aabc", "");
		// lexico(0,1000);
		//palinpart("ababba", "");
		// queenperm(new boolean[4],0,2,"");
		// queencomb(new boolean[4],0,2,"",0);
		// change(new int[] {2, 3, 5,6},10,"", 0);
//		String str = "1??0?101";
//		char []stra = new char[str.length()];
//		for(int i = 0; i<stra.length; i++)
//		{
//			stra[i] = str.charAt(i);
//		}
//		question(stra,0);
		// queenbox2d(new boolean[3][3], 0, 0, 0, 2, "");
//		int [][] board = {{0,1,0,0},{0,0,0,0},{0,1,0,0},{0,0,1,0}};
//		blockmaze(board,0,0, "", new boolean[4][4]);
		// queenbox(new boolean[4], 0, 0, 2, "");

	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";

		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";

	}

	public static void printss(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + "\t");
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		printss(roq, ans);
		printss(roq, ans + ch);
	}

	public static void keypad(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		String code = getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			char cch = code.charAt(i);
			keypad(roq, ans + cch);
		}
	}

	public static void perm(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + "\t");
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		for (int i = 0; i <= ans.length(); i++) {
			String newans = ans.substring(0, i) + ch + ans.substring(i);
			perm(roq, newans);
		}
	}

	public static void perm2(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + "\t");
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			String newques = ques.substring(0, i) + ques.substring(i + 1);
			perm2(newques, ans + ques.charAt(i));
		}
	}

	public static void paran(int n, String ans, int open, int close) {
		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}
		if (open > n || close > n || close > open)
			return;
		paran(n, ans + "(", open + 1, close);
		paran(n, ans + ")", open, close + 1);
	}

	public static void board(int curr, int end, String ans) {

		if (curr > end) {
			return;
		}
		if (curr == end) {
			System.out.println(ans);
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			board(curr + dice, end, ans + dice);
		}
	}

	public static void maze(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}
		if (cc + 1 <= er) {
			maze(cr, cc + 1, er, ec, ans + "H");
		}
		if (cr + 1 <= ec) {
			maze(cr + 1, cc, er, ec, ans + "V");
		}
		if (cr + 1 <= er && cc + 1 <= ec) {
			maze(cr + 1, cc + 1, er, ec, ans + "D");
		}
	}

	public static void permduplic(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			String newques = ques.substring(0, i) + ques.substring(i + 1);
			char ch = ques.charAt(i);
			int flag = 0;
			for (int j = i + 1; j < ques.length(); j++) {
				if (ques.charAt(j) == ch) {
					flag = 1;
				}
			}
			if (flag == 0)
				permduplic(newques, ans + ques.charAt(i));
		}
	}

	public static void lexico(int curr, int end) {
		if (curr > end) {
			return;
		}
		System.out.println(curr);
		int i = 0;
		if (curr == 0)
			i = 1;
		for (; i <= 9; i++) {
			lexico(curr * 10 + i, end);
		}
	}

	public static boolean palindrome(String str) {
		int n = str.length();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(n - 1 - i))
				return false;
		}
		return true;
	}

	public static void palinpart(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i <= ques.length(); i++) {
			String part = ques.substring(0, i);
			String roq = ques.substring(i);
			if (palindrome(part)) {
				palinpart(roq, ans + part + " ");
			}
		}

	}

	public static void queenperm(boolean[] board, int qpsf, int tq, String ans) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i] == false) {
				board[i] = true;
				queenperm(board, qpsf + 1, tq, ans + "q" + qpsf + "b" + i);
				board[i] = false;
			}
		}

	}

	public static void question(char[] str, int ind) {
		if (ind == str.length) {
			for (int i = 0; i < str.length; i++) {
				System.out.print(str[i]);
			}
			System.out.print(" ");
			return;
		}
		if (str[ind] == '?') {
			str[ind] = '0';
			question(str, ind + 1);
			str[ind] = '1';
			question(str, ind + 1);
			str[ind] = '?';
		} else
			question(str, ind + 1);
	}

	public static void queencomb(boolean[] board, int qpsf, int tq, String ans, int last) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		for (int i = last; i < board.length; i++) {
			if (board[i] == false) {
				board[i] = true;
				queencomb(board, qpsf + 1, tq, ans + "q" + qpsf + "b" + i, i);
				board[i] = false;
			}
		}

	}

	public static void change(int[] denom, int amount, String ans, int last) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		if (amount < 0)
			return;
		for (int i = last; i < denom.length; i++) {
			change(denom, amount - denom[i], ans + denom[i], i);
		}
	}

	public static void queenbox(boolean[] board, int col, int qpsf, int tq, String ans) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (col == board.length)
			return;
		board[col] = true;
		queenbox(board, col + 1, qpsf + 1, tq, ans + "b" + col + "q" + qpsf);
		board[col] = false;
		queenbox(board, col + 1, qpsf, tq, ans);
	}

	public static void queenbox2d(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length) {
			return;
		}
		if (isitsafe(board, row, col)) {
			board[row][col] = true;
			queenbox2d(board, row, col + 1, qpsf + 1, tq, ans + "b" + row + col + " " + qpsf);
			board[row][col] = false;
		}
		queenbox2d(board, row, col + 1, qpsf, tq, ans);
	}

	public static boolean isitsafe(boolean[][] board, int row, int col) {
		int r = row - 1;
		int c = col;
		while (r >= 0) {
			if (board[r][c])
				return false;
			r--;
		}
		r = row;
		c = col - 1;
		while (c >= 0) {
			if (board[r][c])
				return false;
			c--;
		}
		r = row - 1;
		c = col - 1;
		while (c >= 0 && r >= 0) {
			if (board[r][c])
				return false;
			c--;
			r--;
		}
		r = row - 1;
		c = col + 1;
		while (c < board[0].length && r >= 0) {
			if (board[r][c])
				return false;
			c++;
			r--;
		}
		return true;
	}

	public static void blockmaze(int[][] board, int cr, int cc, String ans, boolean[][] visited) {
		if (cr == board.length - 1 && cc == board[0].length - 1) {
			System.out.println(ans);
			return;
		}
		if (cr >= board.length || cc >= board[0].length || cr < 0 || cc < 0 || visited[cr][cc] || board[cr][cc] == 1)
			return;
		visited[cr][cc] = true;
		blockmaze(board, cr, cc + 1, ans + "R", visited);
		blockmaze(board, cr + 1, cc, ans + "D", visited);
		blockmaze(board, cr - 1, cc, ans + "T", visited);
		blockmaze(board, cr, cc - 1, ans + "L", visited);
		visited[cr][cc] = false;

	}

	public static boolean wordsearch(char[][] arr, int row, int col, String word, int idx, boolean[][] visited) {
		if (idx == word.length())
			return true;
		if (row < 0 || row == arr.length || col < 0 || col == arr[0].length || visited[row][col])
			return false;
		if (arr[row][col] != word.charAt(idx))
			return false;
		visited[row][col] = true;
		boolean t = wordsearch(arr, row - 1, col, word, idx + 1, visited);
		boolean d = wordsearch(arr, row + 1, col, word, idx + 1, visited);
		boolean l = wordsearch(arr, row, col - 1, word, idx + 1, visited);
		boolean r = wordsearch(arr, row, col + 1, word, idx + 1, visited);
		visited[row][col] = false;
		return t || d || r || l;
	}
	public static int solve(int[][] arr){
        boolean [][] visited = new boolean[arr.length][arr.length];
        for(int r=0; r<arr.length; r++){
            for(int c=0; c<arr[0].length; c++){
                if(arr[r][c]==1){
                    return paths(arr,r,c,visited);
                }
            }
        }
        return 0;
    }
    public static int paths(int [][]arr, int row, int col, boolean [][]visited){
        if(row<0||row==arr.length||col==arr[0].length||col<0){
            return 0;
        }
        if(arr[row][col]==-1||visited[row][col]){
            return 0;
        }
        if(arr[row][col]==2){
            return 1;
        }
        visited[row][col] = true;
        int up = paths(arr,row-1, col, visited);
        int down = paths(arr,row+1, col, visited);
        int right = paths(arr,row, col+1,visited);
        int left = paths(arr,row, col-1, visited);
        visited[row][col] = false;
        return up+down+left+right;
    }

}

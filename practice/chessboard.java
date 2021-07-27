package practice;
import java.util.*;
public class chessboard {
    static int count=0;
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        boolean[][] board=new boolean[n][n];
        chess(board,0,0,"");
        System.out.println();
        System.out.print(count);
    }
    public static void chess(boolean[][] board,int col,int row,String ans) {
        
        if (col==board[0].length-1 && row==board.length-1)
        {
            System.out.print(ans+"{"+(row)+"-"+(col)+"}"+" ");
            count++;
            return;
        }
        
        if(row>=board.length||col>=board[0].length)
        {
            return;
        }
        chess(board,col+1,row+2,ans+"{"+(row)+"-"+(col)+"}"+"K");
        chess(board,col+2,row+1,ans+"{"+(row)+"-"+(col)+"}"+"K");
        
        if(row==0||col==0||row==board.length-1||col==board[0].length-1)
        {
            for(int i=1;i+col<board[0].length;i++)
            {
                chess(board,col+i,row,ans+"{"+(row)+"-"+(col)+"}"+"R");
            }
            
            for(int i=1;i+row<board.length;i++)
            {
                chess(board,col,row+i,ans+"{"+(row)+"-"+(col)+"}"+"R");
            }
        }
        if(row==col||row+col==board.length-1) 
           {
            for(int i=1;i+col<board[0].length&&i+row<board.length;i++)
            {
                chess(board,col+i,row+i,ans+"{"+(row)+"-"+(col)+"}"+"B");
            }
           } 
    }
}


package practice;
import java.util.*;
public class RatInMaze {
    static int count = 0;
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char [][] maze = new char[n][m];
        for(int i = 0; i<n ;i++)
        {
        	String s=sc.next();
            for(int j = 0; j<m; j++)
            {
                maze[i][j] = s.charAt(j);
            }
        }
        int [][] path = new int[n][m];
        boolean [][] visited = new boolean[n][m];
        findpath(maze,0,0,path,visited);
        System.out.println();
        if(count==0)
          System.out.println("NO PATH FOUND");
        
    
    }
    public static void findpath(char[][]maze, int row, int col, int[][]path,boolean[][]visited)
    {
    	if(row<0||row==maze.length||col<0||col==maze[0].length||visited[row][col]||maze[row][col]=='X')
            return;
    	
        if(row==maze.length-1&&col==maze[0].length-1)
        {
        	path[row][col] = 1;
        	for(int i = 0; i<path.length; i++)
            {
               for(int j = 0; j<path[0].length; j++)
               {
                   System.out.print(path[i][j]+" ");
               }
               System.out.println();
            }
        	System.out.println();
            count++;
            return;
        }
        
        visited[row][col] = true;
        path[row][col] = 1;
         findpath(maze,row-1,col,path,visited);
         findpath(maze,row+1,col,path,visited);
         findpath(maze,row,col+1,path,visited);
         findpath(maze,row,col-1,path,visited);
        visited[row][col] = false;
        path[row][col] = 0;
    }
}

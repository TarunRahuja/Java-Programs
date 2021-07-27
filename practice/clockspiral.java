package practice;

import java.util.*;
public class clockspiral {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
//        int row = sc.nextInt();
//        int col = sc.nextInt();
//        int [][]arr = new int[row][col]; 
       int[][] arr = {{11,12,13,14},{21,22,23,24},{31,32,33,34},{41,42,43,44}};
       int row = arr.length;
       int col = arr[0].length;
//        for(int i = 0; i<row; i++)
//        {
//            for(int j = 0; j<col; j++)
//            {
//                arr[i][j] = sc.nextInt();
//            }
//        }
        int total = row*col;
        int count = 1;
        int minr = 0,maxr = arr.length-1, minc = 0, maxc = arr[0].length-1;
        while(count<=total)
        {
            for(int j = minc;count<=total&&j<=maxc; j++)
            {
                System.out.print(arr[minr][j]+","+" ");
                count++;
            }
            minr++;
             for(int i = minr;count<=total&&i<=maxr; i++)
            {
                System.out.print(arr[i][maxc]+","+" ");
                count++;
            }
            maxc--;
             for(int j = maxc;count<=total&&j>=minc; j--)
            {
                System.out.print(arr[maxr][j]+","+" ");
                count++;
            }
            maxr--;
             for(int i = maxr;count<=total&&i>=minr; i--)
            {
                System.out.print(arr[i][minc]+","+" ");
                count++;
            }
            minc++;
        }
        System.out.println("END");
    }
}

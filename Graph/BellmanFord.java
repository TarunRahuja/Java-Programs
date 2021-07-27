package Graph;
import java.util.*;
public class BellmanFord {

	public static void main(String[] args) {
		int [][] adj = {{0,4,8,0,0},{4,0,2,5,0},{8,2,0,5,9},{0,5,5,0,4},{0,0,9,4,0}};
		int []path = new int[5];
		int src = 0;
		for(int i=0; i<5; i++) {
			if(i!=src) {
				path[i] = Integer.MAX_VALUE;
			}
		}
		for(int c=0; c<4 ; c++) {
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(adj[i][j]!=0&&path[i]+adj[i][j]<path[j]) {
						path[j] = path[i]+adj[i][j];
					}
				}
			}
		}
		for(int i=0; i<5; i++) {
			  System.out.println(src+" -> "+i+" = "+path[i]);
		  }
	}

}

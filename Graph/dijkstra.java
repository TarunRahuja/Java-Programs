package Graph;
import java.util.*;
public class dijkstra {
	public static void main(String[] args) {
		int [][] adj = {{0,4,8,0,0},{4,0,2,5,0},{8,2,0,5,9},{0,5,5,0,4},{0,0,9,4,0}};
		int []status = new int[5];
		int []path = new int [5];
		int src = 0;
		for(int i=0; i<5; i++) {
			if(i!=src) {
				path[i] = Integer.MAX_VALUE;
			}
		}
	  while(true) {	
		  int curr = findmin(path,status);
		  if(curr==-1)
			break;
		  status[curr] = 1;
		  for(int nbr = 0; nbr<5; nbr++) {
			  if(adj[curr][nbr]!=0&&path[curr]+adj[curr][nbr]<path[nbr]&&status[nbr]==0){
				  path[nbr] = path[curr]+adj[curr][nbr];
			  }
		  }
	  }
	  for(int i=0; i<5; i++) {
		  System.out.println(src+" -> "+i+" = "+path[i]);
	  }
	}
	public static int findmin(int []path,int []status) {
		int min = Integer.MAX_VALUE;
		int minv = -1;
		for(int i=0; i<path.length; i++) {
			if(path[i]<min&&status[i]==0) {
				min = path[i];
				minv = i;
			}
		}
		return minv;
	}
}

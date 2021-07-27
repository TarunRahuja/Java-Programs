package Graph;
import java.util.*;
public class Prims {
	public static void main(String[] args) {
		int [][] adj = {{0,4,8,0,0},{4,0,2,6,0},{8,2,0,3,9},{0,6,3,0,5},{0,0,9,5,0}};
		int []status = new int[5];
		int []path = new int[5];
		int []parent = new int[5];
		int src = 0;
		for(int i=0; i<5; i++) {
			if(i!=src) {
				path[i] = Integer.MAX_VALUE;
			}
			parent[i] = -1;
		}
		while(true) {
			int curr = findmin(path, status);
			if(curr==-1) {
				break;
			}
			status[curr] = 1;
			for(int nbr = 0; nbr<5; nbr++) {
				if(adj[curr][nbr]!=0 && adj[curr][nbr]<path[nbr]&&status[nbr]==0) {
					path[nbr] = adj[curr][nbr];
					parent[nbr] = curr;
				}
			}
		}
		int sum = 0;
		for(int i=0; i<path.length; i++) {
			sum+=path[i];
		}
		System.out.println("Sum of weights of MST: "+sum);
		System.out.println("----------------");
		for(int i=0;i<parent.length; i++) {
			System.out.println(parent[i]+" --> "+i);
		}
	}
	public static int findmin(int[]path, int []status) {
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

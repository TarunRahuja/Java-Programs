package Graph;
import java.util.*;
public class Kruskal {
	static class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int wt;
		public Edge(int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
		@Override
		public int compareTo(Edge o) {
			return this.wt-o.wt;			
		}		
	}
	static class Graph{
		int vertices;
		ArrayList<Edge> allEdges = new ArrayList<>();
		public Graph(int vertices) {
			this.vertices = vertices;
		}
		public void addEdge(int src, int dest, int wt) {
			Edge edge = new Edge(src, dest, wt);
			allEdges.add(edge);
		}
		public void kruskalMST() {
			PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges);
//			for(int i=0; i<allEdges.size(); i++) {
//				pq.add(allEdges.get(i));
//			}
			int [] parent = new int[vertices];
			MakeSet(parent);
			ArrayList<Edge> mst = new ArrayList<>();
			int count = 0;
			while(count<vertices-1) {
				Edge edge = pq.remove();
				if(find(parent,edge.src)==find(parent,edge.dest)) {
					continue;
				}
				else {
					mst.add(edge);
					count++;
					union(parent, edge.src, edge.dest);
				}
			}
			System.out.println("The Minimum Spanning Tree is:");
			int e = 0;
			int sum = 0;
			for(Edge edge:mst){
				sum+=edge.wt;
				System.out.println("Edge:"+e+" Source: "+edge.src+" Destination: "+edge.dest+" Weight: "+edge.wt);
				e++;
			}
			System.out.println("Sum of weigths.of all edges: "+sum);
		}
		public void MakeSet(int []parent) {
			for(int i=0; i<parent.length; i++) {
				parent[i] = i;
			}
		}
		public int find(int []parent , int vertex) {
			 if(parent[vertex] == vertex) {
				 return vertex;
			 }
			 return find(parent, parent[vertex]);
		}
		public void union(int []parent,int x, int y) {
			int parentx = find(parent,x);
			int parenty = find(parent,y);
			parent[parenty] = parentx;
		}
	}
	public static void main(String[] args) {
		int vertices = 6;
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 4);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 5, 6);
		graph.kruskalMST();
	}
}

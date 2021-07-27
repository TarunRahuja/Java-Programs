package Graph;

public class GraphClient {

	public static void main(String[] args) {
	  Graph gp = new Graph(7);
	  gp.addEdge(1, 2, 3);
	  gp.addEdge(1, 3, 2);
	  gp.addEdge(2, 4, 8);
	  gp.addEdge(2, 5, 1);
	  gp.addEdge(3, 4, 5);
	  gp.addEdge(5, 6, 6);
	  gp.addEdge(5, 7, 7);
	  gp.addEdge(6, 7, 1);
	  //gp.removeEdge(2, 5);
	  gp.removeEdge(3, 4);
	  gp.removeEdge(6, 7);
	  //System.out.println(gp.hasPath(1, 6));
	 // gp.hasAllPath(1, 6);
	 // gp.shortestPair(1, 6);
	 // gp.DFS(1,6);
	 // System.out.println(gp.hasCycle());
	 // System.out.println(gp.getConnected());
	  System.out.println(gp.isBipartite());
	  //System.out.println(gp.isTree());
	  //System.out.println(gp);
	  

	}

}

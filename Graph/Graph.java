package Graph;

import java.util.*;

public class Graph {
	int numV;
	int[][] matrix;

	public Graph() {
		this(5);
	}

	public Graph(int n) {
		numV = n;
		matrix = new int[n + 1][n + 1];
	}

	public void addEdge(int u, int v, int c) {
		matrix[u][v] = c;
		matrix[v][u] = c;
	}

	public int removeEdge(int u, int v) {
		int temp = matrix[u][v];
		matrix[u][v] = 0;
		matrix[v][u] = 0;
		return temp;
	}

	public int numofEdges() {
		int count = 0;
		for (int i = 1; i <= numV; i++) {
			for (int j = 1; j <= numV; j++) {
				if (matrix[i][j] != 0)
					count++;
			}
		}
		return count / 2;
	}

	public boolean containsEdge(int u, int v) {
		return matrix[u][v] != 0;
	}

	public String toString() {
		for (int i = 1; i <= numV; i++) {
			System.out.print(i + "-->");
			for (int j = 1; j <= numV; j++) {
				if (matrix[i][j] != 0)
					System.out.print(j + "[" + matrix[i][j] + "]" + " ");
			}
			System.out.println();
		}
		return "";
	}

	public boolean hasPath(int u, int v) {
		HashMap<Integer, Boolean> visited = new HashMap<>();
		boolean ans = hasPath(u, v, visited);
		return ans;
	}

	private boolean hasPath(int src, int dst, HashMap<Integer, Boolean> visited) {
		if (this.containsEdge(src, dst))
			return true;
		visited.put(src, true);
		for (int nbr = 1; nbr < matrix[src].length; nbr++) {
			boolean ans = false;
			if (!visited.containsKey(nbr) && matrix[src][nbr] != 0)
				ans = hasPath(nbr, dst, visited);
			if (ans)
				return true;
		}
		return false;
	}

	private void hasAllPath(int src, int dst, HashMap<Integer, Boolean> visited, String asf) {
		if (src == dst) {
			System.out.println(asf + dst);
			return;
		}
		visited.put(src, true);
		for (int nbr = 1; nbr < matrix[src].length; nbr++) {
			// boolean ans = false;
			if (!visited.containsKey(nbr) && matrix[src][nbr] != 0)
				hasAllPath(nbr, dst, visited, asf + src);
		}
		visited.remove(src);
	}

	public void hasAllPath(int u, int v) {
		HashMap<Integer, Boolean> visited = new HashMap<>();
		hasAllPath(u, v, visited, "");
	}

	private class pair {
		int data;
		String asf;
		String color;

		pair(int d, String s) {
			data = d;
			asf = s;
		}
        pair(int d,String s,String Color)
        {
        	data = d;
            asf = s;
            this.color = color;
        }

	}

	// BFS
	public boolean shortestPair(int src, int dst) {
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();
		pair np = new pair(src, "");
		queue.addLast(np);
		while (!queue.isEmpty()) {
			pair rp = queue.removeFirst();
			// System.out.println(rp.data);
			if (visited.containsKey(rp.data)) {
				continue;
			}
			visited.put(rp.data, true);
			if (containsEdge(rp.data, dst)) {
				System.out.println(rp.asf + rp.data + dst);
				return true;
			}
			for (int nbr = 1; nbr < matrix[0].length; nbr++) {
				if (matrix[rp.data][nbr] != 0 && !visited.containsKey(nbr)) {
					queue.addLast(new pair(nbr, rp.asf + rp.data));
				}
			}
		}
		return false;
	}

	public boolean DFS(int src, int dst) {
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();
		pair np = new pair(src, "");
		stack.addFirst(np);
		while (!stack.isEmpty()) {
			pair rp = stack.removeFirst();
			// System.out.println(rp.data);
			if (visited.containsKey(rp.data)) {
				continue;
			}
			visited.put(rp.data, true);
			if (containsEdge(rp.data, dst)) {
				System.out.println(rp.asf + rp.data + dst);
				return true;
			}
			for (int nbr = 1; nbr < matrix[0].length; nbr++) {
				if (matrix[rp.data][nbr] != 0 && !visited.containsKey(nbr)) {
					stack.addFirst(new pair(nbr, rp.asf + rp.data));
				}
			}
		}
		return false;
	}

	public void BFT() {
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();
		for (int i = 1; i <= numV; i++) {
			if (visited.containsKey(i)) {
				continue;
			}
			pair np = new pair(i, "");
			queue.addLast(np);
			while (!queue.isEmpty()) {
				pair rp = queue.removeFirst();
				// System.out.println(rp.data);
				if (visited.containsKey(rp.data)) {
					continue;
				}
				visited.put(rp.data, true);
				System.out.println(rp.data + " coming via " + rp.asf + rp.data);

				for (int nbr = 1; nbr < matrix[0].length; nbr++) {
					if (matrix[rp.data][nbr] != 0 && !visited.containsKey(nbr)) {
						queue.addLast(new pair(nbr, rp.asf + rp.data));
					}
				}
			}
		}
	}

	public void DFT() {
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();
		for (int i = 1; i <= numV; i++) {
			if (visited.containsKey(i)) {
				continue;
			}
			pair np = new pair(i, "");
			stack.addFirst(np);
			while (!stack.isEmpty()) {
				pair rp = stack.removeFirst();
				// System.out.println(rp.data);
				if (visited.containsKey(rp.data)) {
					continue;
				}
				visited.put(rp.data, true);
				System.out.println(rp.data + " coming via " + rp.asf + rp.data);

				for (int nbr = 1; nbr < matrix[0].length; nbr++) {
					if (matrix[rp.data][nbr] != 0 && !visited.containsKey(nbr)) {
						stack.addFirst(new pair(nbr, rp.asf + rp.data));
					}
				}
			}
		}
	}

	public boolean hasCycle() {
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();
		for (int i = 1; i <= numV; i++) {
			if (visited.containsKey(i)) {
				continue;
			}
			pair np = new pair(i, "");
			queue.addLast(np);
			while (!queue.isEmpty()) {
				pair rp = queue.removeFirst();
				// System.out.println(rp.data);
				if (visited.containsKey(rp.data)) {
					return true;
				}
				visited.put(rp.data, true);
				// System.out.println(rp.data+" coming via "+rp.asf+rp.data);

				for (int nbr = 1; nbr < matrix[0].length; nbr++) {
					if (matrix[rp.data][nbr] != 0 && !visited.containsKey(nbr)) {
						queue.addLast(new pair(nbr, rp.asf + rp.data));
					}
				}
			}
		}
		return false;
	}
	public boolean isConnected() {
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();
		int count = 0;
		for (int i = 1; i <= numV; i++) {
			if (visited.containsKey(i)) {
				continue;
			}
			count++;
			pair np = new pair(i, "");
			queue.addLast(np);
			while (!queue.isEmpty()) {
				pair rp = queue.removeFirst();
				// System.out.println(rp.data);
				if (visited.containsKey(rp.data)) {
					continue;
				}
				visited.put(rp.data, true);
				
				//System.out.println(rp.data + " coming via " + rp.asf + rp.data);

				for (int nbr = 1; nbr < matrix[0].length; nbr++) {
					if (matrix[rp.data][nbr] != 0 && !visited.containsKey(nbr)) {
						queue.addLast(new pair(nbr, rp.asf + rp.data));
					}
				}
			}
		}
		return count<=1;
	}
	public boolean isTree()
	{
		return !hasCycle()&&isConnected();
	}
	public ArrayList<ArrayList<Integer>> getConnected()
	{
		ArrayList<ArrayList<Integer>> finalans = new ArrayList<>();
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();
		for (int i = 1; i <= numV; i++) {
			if (visited.containsKey(i)) {
				continue;
			}
			ArrayList<Integer> comp = new ArrayList<>();
			pair np = new pair(i, "");
			queue.addLast(np);
			while (!queue.isEmpty()) {
				pair rp = queue.removeFirst();
				// System.out.println(rp.data);
				if (visited.containsKey(rp.data)) {
					continue;
				}
				visited.put(rp.data, true);
				comp.add(rp.data);
				//System.out.println(rp.data + " coming via " + rp.asf + rp.data);

				for (int nbr = 1; nbr < matrix[0].length; nbr++) {
					if (matrix[rp.data][nbr] != 0 && !visited.containsKey(nbr)) {
						queue.addLast(new pair(nbr, rp.asf + rp.data));
					}
				}
			}
			finalans.add(comp);
		}
		return finalans;
	}
	public boolean isBipartite()
	{
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<Integer, String> visited = new HashMap<>();
		for (int i = 1; i <= numV; i++) {
			if (visited.containsKey(i)) {
				continue;
			}
			pair np = new pair(i, "","R");
			queue.addLast(np);
			while (!queue.isEmpty()) {
				pair rp = queue.removeFirst();
				//System.out.println(rp.data);
				if (visited.containsKey(rp.data)) {
					String nc = rp.color;
					String oc = visited.get(rp.data);
					if(!oc.equals(nc))
						return false;
					continue;
				}
				visited.put(rp.data, rp.color);
				//System.out.println(rp.data + " coming via " + rp.asf + rp.data);

				for (int nbr = 1; nbr < matrix[0].length; nbr++) {
					if (matrix[rp.data][nbr] != 0 && !visited.containsKey(nbr)) {
						String newcolor = rp.color== "R"?"G":"R";
						queue.addLast(new pair(nbr, rp.asf + rp.data,newcolor));
					}
				}
			}
		}
		return true;
	}
}

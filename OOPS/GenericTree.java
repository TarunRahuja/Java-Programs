package OOPS;

import java.util.*;
import java.util.LinkedList;;


public class GenericTree {
	Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		root = construct(null, -1);
	}

	private Node construct(Node parent, int i) {
		if (parent == null) {
			System.out.println("Enter the data for the root node");

		} else {
			System.out.println("enter the value of " + i + " th child" + "of" + parent.data);
		}
		int item = sc.nextInt();
		Node nn = new Node();
		nn.data = item;
		System.out.println("Enter number of children " + nn.data);
		int noc = sc.nextInt();
		for (int j = 0; j < noc; j++) {
			Node child = construct(nn, j);
			nn.children.add(child);
		}
		return nn;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		String ans = new String();
		ans = ans + node.data + "--> ";
		for (Node child : node.children) {
			ans = ans + child.data + " ";
		}
		System.out.println(ans);
		for (Node child : node.children) {
			display(child);
		}
	}

	private int count(Node node) {
		int size = 0;
		for (Node child : node.children) {
			size += count(child);
		}
		return size + 1;
	}

	public int maximum() {
		int ans = maximum(root);
		return ans;
	}

	private int maximum(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int maximum = maximum(child);
			max = (max < maximum) ? maximum : max;
		}
		return max;
	}

	private boolean search(Node node, int item) {
		boolean ans = false;
		if (node.data == item) {
			ans = true;
			return ans;
		}
		for (Node child : node.children) {
			ans = search(child, item);
			if (ans)
				return true;
		}
		return false;

	}

	public boolean search(int item) {
		boolean ans = search(root, item);
		return ans;
	}

	private int height(Node node) {
		int th = -1;
		for (Node child : node.children) {
			int ch = height(child);
			th = Math.max(th, ch);
		}
		return th + 1;
	}

	public void height() {
		System.out.println(height(root));
	}

	private void mirror(Node node) {
		for (int i = 0; i < node.children.size() / 2; i++) {
			Node temp = node.children.get(i);
			node.children.set(i, node.children.get(node.children.size() - i - 1));
			node.children.set(node.children.size() - i - 1, temp);
		}
		for (Node child : node.children) {
			mirror(child);
		}
	}

	public void mirror() {
		mirror(root);
	}

	private void printLevel(Node node, int level, int count) {

		if (count == level) {
			System.out.print(node.data + " ");
			return;
		}
		for (Node child : node.children) {
			printLevel(child, level, count + 1);
		}

	}

	public void printLevel(int level) {
		printLevel(root, level, 0);
	}

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}
		while (node.children.size() > 1) {
			Node temp = node.children.get(1);
			node.children.remove(1);
			gettail(node.children.get(0)).children.add(temp);
		}
	}

	private Node gettail(Node node) {
		if (node.children.size() == 0) {
			return node;
		}
		return gettail(node.children.get(0));
	}

	public void Linearize() {
		linearize(root);
	}

	private void preorder(Node node) {
		System.out.println(node.data);
		for (Node child : node.children) {
			preorder(child);
		}
	}

	public void preorder() {
		preorder(root);
	}
	public void LevelOrder() {
	
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		
		while(!queue.isEmpty())
		{
			Node remnode = queue.removeFirst();
		    System.out.print(remnode.data+" ");
			for(Node child:remnode.children)
			{
				queue.addLast(child);
			}
			
		}
	}
	public void LevelOrder1() {
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		queue.addLast(null);
		
		while(!queue.isEmpty())
		{
			Node remnode = queue.removeFirst();
		    if(queue.isEmpty())
		    {
		    	if(remnode==null)
		    		break;
		    }
			if(remnode==null)
		    {
		    	System.out.println();
		    	queue.addLast(null);
		    	continue;
		    }
			System.out.print(remnode.data+" ");
			for(Node child:remnode.children)
			{
				queue.addLast(child);
			}
			
		}
}
	public void LevelOrder2() {
		
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		queue.addLast(root);
		while(!queue.isEmpty())
		{
			Node remnode = queue.removeFirst();
		    System.out.print(remnode.data+" ");
		    for(Node child:remnode.children)
		    {
		    	helper.addLast(child);
		    }
		    if(queue.isEmpty())
		    {
		    	System.out.println();
		    	queue = helper;
		    	helper = new LinkedList<>();
		    }
			
		}
	}
		public void LevelOrderZZ() {
			int count = 0;
			LinkedList<Node> Stack = new LinkedList<>();
			LinkedList<Node> helper = new LinkedList<>();
			Stack.addFirst(root);
			while(!Stack.isEmpty())
			{
				Node remnode = Stack.removeFirst();
			    System.out.print(remnode.data+" ");
			    if(count%2==0) {
			    for(Node child:remnode.children)
			    {
			    	helper.addFirst(child);
			    }
			    }
			    else
			    {
			    	for(int i = remnode.children.size()-1;i>=0; i--)
			    	{
			    		helper.addFirst(remnode.children.get(i));
			    	}
			    }
			    if(Stack.isEmpty())
			    {
			    	System.out.println();
			    	count++;
			    	Stack = helper;
			    	helper = new LinkedList<>();
			    }
				
			}
	}
	
}

package BinarySearchTree;

public class BinarySearchTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinarySearchTree(int[] inorder) {
		root = construct(inorder, 0, inorder.length - 1);
	}

	private Node construct(int[] inorder, int low, int hi) {
		if (low > hi)
			return null;
		int mid = (low + hi) / 2;
		Node nn = new Node();
		nn.data = inorder[mid];
		nn.left = construct(inorder, low, mid - 1);
		nn.right = construct(inorder, mid + 1, hi);
		return nn;
	}

	public void display() {
		display(root);

	}

	private void display(Node node) {
		if (node == null)
			return;
		String ans = "";
		if (node.left == null) {
			ans = ans + ".";
		} else {
			ans = ans + node.left.data;
		}
		ans = ans + "-->" + node.data;
		if (node.right == null) {
			ans = ans + "-->.";
		} else {
			ans = ans + "-->" + node.right.data;
		}
		System.out.println(ans);
		display(node.left);
		display(node.right);
	}

	private int size(Node node) {
		int count = 0;
		if (node == null) {
			return 0;
		}
		count += size(node.left);
		count += size(node.right);
		return count + 1;
	}

	public void size() {
		int ans = size(root);
		System.out.println(ans);
	}

	private int max(Node node) {
		if (node.right == null)
			return node.data;
		return max(node.right);
	}

	public void max() {
		int ans = max(root);
		System.out.println(ans);
	}

	private boolean find(Node node, int item) {
		if (node == null)
			return false;
		if (node.data == item)
			return true;
		else if (node.data < item) {
			return find(node.right, item);
		} else {
			return find(node.left, item);
		}
	}

	public void find(int item) {
		boolean ans = find(root, item);
		System.out.println(ans);
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		int lh = height(node.left);
		int rh = height(node.right);
		return Math.max(lh, rh) + 1;
	}

	public void height() {
		int ans = height(root);
		System.out.println(ans);
	}

	public void printrange(int low, int hi) {
		printrange(root, low, hi);
	}

	private void printrange(Node node, int low, int hi) {
		if (node == null) {
			return;
		}
		if (node.data < low) {
			printrange(node.right, low, hi);
		} else if (node.data >= low && node.data <= hi) {

			printrange(node.left, low, hi);
			System.out.print(node.data + " ");
			printrange(node.right, low, hi);

		} else {
			printrange(node.left, low, hi);
		}

	}

	private void replace(Node node, int[] sum) {
		if (node == null)
			return;
		replace(node.right, sum);
		int temp = node.data;
		node.data = sum[0];
		sum[0] += temp;
		replace(node.left, sum);
	}

	public void replace() {
		int[] sum = new int[1];
		replace(root, sum);
//		System.out.println(sum[0]);
	}

	private void add(Node node, int item) {
		if (node.left == null && item < node.data) {
			Node nn = new Node();
			nn.data = item;
			node.left = nn;
			return;
		}
		if (node.right == null && item > node.data) {
			Node nn = new Node();
			nn.data = item;
			node.right = nn;
			return;
		}

		if (item > node.data) {
			add(node.right, item);
		} else {
			add(node.left, item);
		}
	}

	public void add(int item) {
		add(root, item);
	}

	private Node addreturn(Node node, int item) {
		if (node == null) {
			Node nn = new Node();
			nn.data = item;
			return nn;
		}
		if (item <= node.data) {
			node.left = addreturn(node.left, item);
		} else {
			node.right = addreturn(node.right, item);
		}
		return node;
	}

	public void addreturn(int item) {
		root = addreturn(root, item);
	}
	private void remove(Node parent , Node node, int item)
	{
		if(node==null)
			return;
		if(node.data==item)
		{
		  if(node.left==null&&node.right==null) {
			  if(node.data<=parent.data)
			  {
				  parent.left = null;
			  }
			  else
			  {
				  parent.right=null;
			  }
		  }
		  else if(node.left!=null&&node.right==null)
		  {
			  if(node.data<=parent.data)
			  {
				  parent.left = node.left;
			  }
			  else
			  {
				  parent.right=node.left;
			  }
		  }
		  else if(node.left==null&&node.right!=null)
		  {
			  if(node.data<=parent.data)
			  {
				  parent.left = node.right;
			  }
			  else
			  {
				  parent.right=node.right;
			  }
		  }
		  else
		  {
				int temp = max(node.left);
				remove(node, node.left, temp);
				node.data = temp;	
		  }
		  
		}
		if(item>node.data)
		{
			remove(node, node.right, item);
		}
		if(item<node.data)
		{
			remove(node, node.left, item);
		}
		
	}
	public void remove(int item)
	{
		remove(null, root, item);
	}
	private Node RemoveReturn(Node node, int item)
	{
		if(node==null)
			return null;
		if(node.data==item)
		{
			if(node.left==null)
				return node.right;
			else if(node.right==null)
				return node.left;
			else
			{
				int temp = max(node.left);
				node.left = RemoveReturn(node.left, temp);
				node.data = temp;
				return node;
			}
			
		}
		else if(node.data<item)
		{
			node.right = RemoveReturn(node.right, item);
		}
		else
		{
			node.left = RemoveReturn(node.left, item);
		}
		return node;
	}
	public void RemoveReturn(int item)
	{
		root = RemoveReturn(root, item);
	}
}

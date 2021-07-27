package avlTree;

public class AVLTree {
	static class Node {
		int data = 0;
		Node left = null;
		Node right = null;
		int height = 0;
		int bal = 0;
		public Node(int data) {
			this.data = data;
		}
		public Node() {
		}
	}
	public static void updateHeightAndBalance(Node node) {
		int lh = -1;
		int rh = -1;
		if(node.left != null) {
			lh = node.left.height;
		}
		if(node.right != null) {
			rh = node.right.height;
		}
		int bal = lh - rh;
		int height = Math.max(lh, rh) + 1;
		node.bal = bal;
		node.height = height;
	}
	public static Node rightRotation(Node A) {
		Node B = A.left;
		Node BRight = B.right;
		B.right = A;
		A.left = BRight;
		updateHeightAndBalance(A);
		updateHeightAndBalance(B);
		return B;
	}
	public static Node leftRotation(Node A) {
		Node B = A.right;
		Node BLeft = B.left;
		B.left = A;
		A.right = BLeft;
		updateHeightAndBalance(A);
		updateHeightAndBalance(B);
		return B;
	}
	public static Node getRotation(Node node) {
		updateHeightAndBalance(node);
		if(node.bal == 2) { //ll,lr
			if(node.left.bal == 1) {
				return rightRotation(node);
			}
			else {
				node.left = leftRotation(node.left);
				return rightRotation(node);
			}
		}
		else if(node.bal == -2) {
			if(node.right.bal == -1) {
				return leftRotation(node);
			}
			else {
				node.right = rightRotation(node.right);
				return leftRotation(node);
			}
		}
		return node;
	}
	public static void main(String[] args) {
		int []arr = new int[]{10,20,30,40,50,60,70,80,90,100};
		Node root = null;
		for(int val : arr) {
			root = addData(root, val);
		}
		display(root);
		System.out.println("------------");
		root = removeData(root, 40);
		display(root);
	}
	public static void display(Node node) {
		if(node == null)return;
		String left = "";
		left += node.left == null ? "." : node.left.data;
		String right = "";
		right += node.right == null ? "." : node.right.data;
		System.out.println(left + " <- " + node.data + " -> " + right);
		display(node.left);
		display(node.right);
	}
	public static Node addData(Node node, int data) {
		if(node == null) {
			return new Node(data);
		}
		if(data < node.data) {
			node.left = addData(node.left, data);
		}
		else if(data > node.data){
			node.right = addData(node.right,data);
		}
		return node = getRotation(node);
	}
	public static Node removeData(Node node, int data) {
		if(node == null) {
			return null;
		}
		if(data < node.data) {
			node.left = removeData(node.left, data);
		}
		else if(data > node.data) {
			node.right = removeData(node.right, data);
		}
		else {
			if(node.left == null || node.right == null) {
				return node.left != null ? node.left : node.right;
			}
			Node maxNode = getMaxNode(node.left);
			node.data = maxNode.data;
			node.left = removeData(node.left, maxNode.data);
		}
		return node = getRotation(node);
	}
	public static Node getMaxNode(Node node) {
		if(node.right == null) {
			return node;
		}
		return getMaxNode(node.right);
	}
}
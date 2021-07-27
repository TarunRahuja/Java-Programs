package SegmentTree;
public class SegmentTree {
  private class Node{
	  int data;
	  int si;
	  int ei;
	  Node left;
	  Node right;
  }
  private Node root;
  public SegmentTree(int []arr)
  {
	  root = construct(arr,0,arr.length-1);
  }
private Node construct(int[] arr, int i, int j) {
	
	Node nn = new Node();
	nn.si = i;
	nn.ei = j;
	if(i==j)
	{
		nn.data = arr[i];
		return nn;
	}
	int mid = (i+j)/2;
	nn.left = construct(arr, i, mid);
	nn.right = construct(arr, mid+1, j);
	nn.data = nn.left.data+nn.right.data;
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
public int query(int qsi,int qei)
{
	return query(root,qsi,qei);
}
private int query(Node node, int qsi, int qei) {
	//full contribution
	if(node.si>=qsi&&node.ei<=qei)
	{
		return node.data;
	}
	//no contribution
	else if(node.si>qei||node.ei<qsi)
	{
		return 0;
	}
	//partial contribution
	else
	{
		int leftq = query(node.left,qsi,qei);
		int rightq = query(node.right,qsi,qei);
		return leftq+rightq;
	}
}
public void update(int idx,int item)
{
	update(root,idx,item);
}
private void update(Node node, int idx,int item) {
	if(idx==node.si&&idx==node.ei)
	{
		node.data = item;
	}
	else if(idx>=node.si&&idx<=node.ei)
	{
		update(node.left,idx,item);
		update(node.right, idx, item);
		node.data = node.left.data+node.right.data;
	}
	else
	{
		return ;
	}
}

}

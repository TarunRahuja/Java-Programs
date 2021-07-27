package segment;
public class SegmentTree {
	public static void main(String[] args) {
		int []  arr = {1,3,2,-2,4,5};
		int [] tree = new int[4*arr.length+1];
		buildTree(tree, arr, 1, 0, 5);
		for(int val:tree) {
			System.out.print(val+" ");
		}
		System.out.println();
		System.out.println(query(tree, 1, 0,5, 1, 3));
		updateNode(tree, 1, 0, 5, 3, -5);
		for(int val:tree) {
			System.out.print(val+" ");
		}
	}
	public static void buildTree(int []tree,int[] arr, int idx,int start, int end) {
		if(start>end) {
			return;
		}
		if(start==end) {
			tree[idx] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		buildTree(tree,arr,2*idx,start,mid);
		buildTree(tree,arr,2*idx+1,mid+1,end);
		int left = tree[2*idx];
		int right = tree[2*idx+1];
		tree[idx] = Math.min(left, right);
	}
	public static int query(int []tree,int idx,int start, int end, int qstart,int qend){
		//no overlap
		if(qstart>end||qend<start) {
			return Integer.MAX_VALUE;
		}
		//complete overlap
		if(start>=qstart&&end<=qend) {
			return tree[idx];
		}
		//partial overlap
		int mid = (start+end)/2;
		int left = query(tree,2*idx,start,mid,qstart,qend);
		int right = query(tree,2*idx+1,mid+1,end,qstart,qend);
		return Math.min(left, right);
	}
	public static void updateNode(int []tree,int index, int start, int end,int idx, int val) {
		 //no overlap
		if(idx<start||idx>end) {
			return;
		}
		//leaf node
		if(start==end) {
			tree[index] = val;
			return;
		}
		//idx lies in range (start,end)
		int mid = (start+end)/2;
		updateNode(tree,2*index, start, mid, idx, val);
		updateNode(tree,2*index+1, mid+1, end, idx, val);
		tree[index] = Math.min(tree[2*index],tree[2*index+1]);
	}
	public static void rangeUpdate(int []tree, int idx,int start, int end, int qstart, int qend,int inc) {
		if(qend<start||qstart>end) {
			return;
		}
		if(start==end) {
			tree[idx]+=inc;
			return;
		}
		int mid = (start+end)/2;
		rangeUpdate(tree, 2*idx, start, mid, qstart, qend, inc);
		rangeUpdate(tree, 2*idx+1, mid+1, end, qstart, qend, inc);
		tree[idx] = Math.min(tree[2*idx], tree[2*idx+1]);
	}
}

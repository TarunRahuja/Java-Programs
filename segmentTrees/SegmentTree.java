package segmentTrees;
import java.util.*;
public class SegmentTree {
	int []st;
	int []lazy;
	public SegmentTree(int []arr) {
		int n = arr.length;
		st = new int[4*n+1];
		lazy = new int[4*n+1];
		buildTree(arr, 0, 0, n-1);
	}
	public void buildTree(int []arr,int si, int ss, int se) {
		if(ss == se) {
			st[si] = arr[ss];
			return;
		}
		int mid = (ss+se)/2;
		buildTree(arr, 2*si+1, ss, mid);
		buildTree(arr, 2*si+2, mid+1, se);
		st[si] = Math.min(st[2*si+1], st[2*si+2]);
	}
	public int query(int si, int ss, int se, int qs, int qe) {
		if(lazy[si] != 0) {
			int dx = lazy[si];
			lazy[si] = 0;
			st[si] += dx;
			if(ss != se) {
				lazy[2*si+1] += dx;
				lazy[2*si+2] += dx;				
			}
		}
		if(qs > se || qe < ss) {
			return Integer.MAX_VALUE;
		}
		if(ss >= qs && se <= qe) {
			return st[si];
		}
		int mid = (ss + se)/2;
		int l = query(2*si+1,ss,mid,qs,qe);
		int r = query(2*si+2, mid+1, se, qs, qe);
		return Math.min(l,r);
	}
	public void update(int []arr,int si, int ss, int se, int qi) {
		if(lazy[si] != 0) {
			int dx = lazy[si];
			lazy[si] = 0;
			st[si] += dx;
			if(ss != se) {
				lazy[2*si+1] += dx;
				lazy[2*si+2] += dx;				
			}
		}
		if(ss == se) {
			st[si] = arr[ss];
			return;
		}
		int mid = (ss + se)/2;
		if(qi <= mid) {
			update(arr,2*si+1,ss,mid,qi);
		}
		else {
			update(arr, 2*si+2, mid+1, se, qi);
		}
		st[si] = Math.min(st[2*si+1], st[2*si+2]);
	}
	public void update(int si, int ss, int se, int l, int r, int val) {
		if(lazy[si] != 0) {
			int dx = lazy[si];
			lazy[si] = 0;
			st[si] += dx;
			if(ss != se) {
				lazy[2*si+1] += dx;
				lazy[2*si+2] += dx;				
			}
		}
		if(se < l || ss > r) {
			return;
		}
		if(ss >= l && se <= r) {
			st[si] += val;
			if(ss != se) {
				lazy[2*si+1] += val;
				lazy[2*si+2] += val;				
			}
			return;
		}
		int mid = (ss + se)/2;
		update(2*si+1,ss,mid,l,r,val);
		update(2*si+2,mid+1,se,l,r,val);
	}
	public void display() {
		for(int val : st) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
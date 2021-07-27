package segmentTrees;
public class SegmentTreeClient {
	public static void main(String[] args) {
		int []arr = new int[] {1,-1,2,3,-2,4,5};
		SegmentTree st = new SegmentTree(arr);
		System.out.println(st.query(0, 0, 6, 1, 4));
//		arr[4] = 10;
//		st.update(arr, 0, 0, 6, 4);
		//System.out.println(st.query(0, 0, 6, 1, 4));
		st.update(0,0,6,1,4,5);
		System.out.println(st.query(0, 0, 6, 1, 4));
	}

}

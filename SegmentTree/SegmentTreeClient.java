package SegmentTree;

public class SegmentTreeClient {

	public static void main(String[] args) {
		int []arr = {2,8,9,10,6,5,4};
		
		//SegmentTree st = new SegmentTree(arr);
		SegmentTreeGen stg = new SegmentTreeGen(arr, new SegmentTreeMax());
		//stg.query(2,5);
		stg.display();
		int ans = stg.query(2, 5);
        System.out.println(ans);
		
	}

}

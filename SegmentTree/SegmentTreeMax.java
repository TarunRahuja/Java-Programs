package SegmentTree;

public class SegmentTreeMax implements SegmentTreeI {

	@Override
	public int operation(int a, int b) {
		return Math.max(a, b);
	}

	@Override
	public int defaultval() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

}

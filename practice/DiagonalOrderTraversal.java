package practice;
public class DiagonalOrderTraversal {
	public static void main(String[] args) {
		int [][]arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int n = arr[0].length;
		for(int slide=0; slide<n; slide++) {
			for(int si=0; si<n-slide; si++) {
				int ei = si+slide;
				System.out.print(arr[si][ei]+" ");
			}
			System.out.println();
		}
	}

}

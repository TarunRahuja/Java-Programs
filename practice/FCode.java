package practice;
import java.util.*;
public class FCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int []arr = new int[n];
		int min = 999999;
		HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			map.put(arr[i],list);
			min = Math.min(min, arr[i]);
		}
		Arrays.sort(arr);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			temp = map.get(arr[i]);
			for(int j=arr[i]; j>=min;j-=k) {
				if(map.containsKey(j)){
				   temp.add(j);
				}
			}
		}
		int maxSize = 0;
		int maxval = 0;
		for(int val:arr) {
			if(map.get(val).size()>maxSize) {
				maxSize = map.get(val).size();
				maxval = val;
			}
		}
		System.out.println(map.get(maxval).size());
		System.out.println(map.get(maxval));
	}
}
//Case 1:
//
//	For the input provided as follows:
//
//	5 2
//	1
//	2
//	3
//	4
//	5
//
//	Output of the program will be:
//
//	3
//	1
//	3
//	5
//
//	Case 2:
//
//	For the input provided as follows:
////
//6 4
//10
//15
//12
//16
//20
//32
//
//	Output of the program will be:
//
//	4
//	12
//	16
//	20
//	32
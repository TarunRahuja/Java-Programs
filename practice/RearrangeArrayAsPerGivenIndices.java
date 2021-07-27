package practice;
import java.util.*;
public class RearrangeArrayAsPerGivenIndices {
	public static void main(String[] args) {
		int[] arr = new int[] {50,40,70,60,90};
		int[] index = new int[] {3,0,4,1,2};
		int n = arr.length;
		for(int i=0; i<n; i++) {
			while(i != index[i]) {
				int oldValue = arr[index[i]];
				int oldIndex = index[index[i]];
				
				arr[index[i]] = arr[i];
				index[index[i]] = index[i];
				
				arr[i] = oldValue;
				index[i] = oldIndex;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}

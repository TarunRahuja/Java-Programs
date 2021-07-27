import java.util.*;
public class DigitalRoots {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String [] arr = str.split(";;;");
//		for(String s: arr) {
//			System.out.println(s);//1,2,3,4,5;;;4,6,9;;;8,9,6,5;;;9,87,54
//		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		for(String s:arr) {
			String [] row = s.split(",");
			for(String rowElement:row) {
				list.add(Integer.parseInt(rowElement));
			}
			a.add(new ArrayList<Integer>(list));
			list = new ArrayList<Integer>();
		}
		int count = 0;
		for(ArrayList<Integer>l:a) {
			count+=getOddRootCount(l);
		}
		System.out.println(count);
		
	}
	public static int getOddRootCount(ArrayList<Integer>a) {
		int sum = 0;
		for(int val:a) {
			sum+=val;
		}
		while(sum>=10) {
			sum = getSumOfDigits(sum);
		}
		if(sum%2==0) {
			return 0;
		}
		return 1;
	}
	private static int getSumOfDigits(int n){
		int sum = 0;
		while(n!=0) {
			sum+=n%10;
			n/=10;
		}
		return sum;
	}
}

package mockvita;
import java.util.*;
public class Qn2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<String> odd = new ArrayList<String>();
		ArrayList<String> even = new ArrayList<String>();
		for(int i=0; i<n; i++) {
			int val = sc.nextInt();
			if(i%2 == 0) {
				odd.add(getBitScore(val));
			}
			else {
				even.add(getBitScore(val));
			}
		}
		System.out.println(getPairs(even)+getPairs(odd));
	}
	public static int getPairs(ArrayList<String> list) {
		int []dig = new int[10];
		for(String str : list) {
			dig[str.charAt(0) - '0']++;
		}
		int ans = 0;
		for(int i=0; i<10; i++) {
			if(dig[i]>=3) {
				ans += 2;
			}
			else {
				ans = ans + (dig[i]*(dig[i]-1))/2;
			}
		}
		return ans;
	}
	public static String getBitScore(int val) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		while(val != 0) {
			min = Math.min(min, (val%10));
			max = Math.max(max, (val%10));
			val /= 10;
		}
		int temp = min*7 + max*11;
		String bitScore = temp+"";
		if(bitScore.length() == 3) {
			return bitScore.substring(1);
		}
		else {
			return bitScore;
		}
	}
}
package stringAlgorithms;
import java.util.*;
public class RabinKarp {
 static int prime = 119;
	public static void main(String[] args) {
		String str = "ababcabdab";
		String pat = "abd";
		long strhash = hash(str,pat.length());
		long pathash = hash(pat, pat.length());
		for(int i=0; i+pat.length()<=str.length(); i++) {
			if(strhash==pathash&&isEqual(str, pat, i, i+pat.length()-1, 0, pat.length()-1))
			{
				System.out.println("Match found at: "+i);
				return;
			}
			if(i+pat.length()<str.length()) {
				strhash = reHash(str, pat, strhash, i, i+pat.length());
			}
		}
		System.out.println("Match not found");
	}
	public static long hash(String str, int n) {
		long ans = 0;
		for(int i=0; i<n; i++) {
			ans = ans+str.charAt(i)*(long)Math.pow(prime, i);
		}
		return ans;
	}
	public static long reHash(String str,String pat,long hash,int oldIdx,int newIdx) {
		long temp = 0;
		temp = hash-(str.charAt(oldIdx));
		temp/=prime;
		temp+= str.charAt(newIdx)*(long)Math.pow(prime,pat.length()-1);
		return temp;
	}
	public static boolean isEqual(String str, String pat,int start1, int end1, int start2, int end2) {
		if(end1-start1!=end2-start2) {
			return false;
		}
		while(start1<=end1&&start2<=end2) {
			if(str.charAt(start1)!=pat.charAt(start2))
				return false;
			start1++;
			start2++;
		}
		return true;
	}
}

package stringAlgorithms;
import java.util.*;
public class CountOfAnagramSubstrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int n = str.length();
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int si=0; si<n; si++) {
			int[] freq = new int[26];
			for(int ei=si; ei<n; ei++) {
				char ch = str.charAt(ei);
				freq[ch-'a']++;
				String key = getKey(freq);
				map.put(key,map.getOrDefault(key,0)+1);
			}
		}
		
		int count = 0;
		for(String key : map.keySet()) {
			int val = map.get(key);
			count += ((val)*(val-1))/2;
		}
		
		System.out.println(count);
	}
	public static String getKey(int[] freq) {
		StringBuilder sb = new StringBuilder();
		for(int val : freq) {
			sb.append(val + " ");
		}
		return sb.toString();
	}
}

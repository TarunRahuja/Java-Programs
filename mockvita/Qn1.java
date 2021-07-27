package mockvita;
import java.util.*;
import java.io.*;
public class Qn1 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String []arr = br.readLine().split(" ");
		String brides = arr[0];
		String grooms = arr[1];
		int i;
		for(i=0; i<n; i++) {
			char ch = brides.charAt(i);
			int j = search(grooms,ch);
			if(j == -1) {
				break;
			}
			else {
				grooms = grooms.substring(0,j) + grooms.substring(j+1);
			}
		}
		System.out.println(n-i);
	}
	public static int search(String grooms, char ch) {
		int n = grooms.length();
		for(int i=0; i<n; i++) {
			if(grooms.charAt(i) == ch) {
				return i;
			}
		}
		return -1;
	}
}
package firstex;
import java.util.*;
import java.io.*;
public class BufferedReaderIo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//to read String
		String str = br.readLine();
		System.out.println(str);
		// to read single Integer
		int n = Integer.parseInt(br.readLine());
		System.out.println(n);
		//to read array values one by one
		int []arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int val:arr) {
			System.out.print(val+" ");
		}
		System.out.println();
		//to read space seperated values
		int []arrSpace = new int[n];
		String[] in = br.readLine().split(" ");
		int j = 0;
		for(String s:in) {
			arrSpace[j++] = Integer.parseInt(s);
		}
		for(int val:arrSpace) {
			System.out.print(val+" ");
		}
		System.out.println();
		//to read single char
		char ch = br.readLine().charAt(0);
		System.out.println(ch);
	}
}

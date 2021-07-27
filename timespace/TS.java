package timespace;

import java.util.*;

public class TS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int x = sc.nextInt();
//		int n = sc.nextInt();
//		System.out.println(powseq(x, n));
		System.out.println(palincount("n"));
		// sieve(25);
		//System.out.println(pow(3, 6));
		//transform("A1bC", "");

	}

	public static int powseq(int x, int n) {
		int sum = 0;
		int prod = x;
		for (int i = n; i >= 1; i--) {
			sum = sum + i * prod;
			prod = prod * x;
		}
		return sum;
	}

	public static int palincount(String str) {
		int count = 0;
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit))
					count++;
				else
					break;
			}
		}
		for (double axis = 0.5; axis < str.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit)))
					count++;
				else
					break;
			}
		}
		return count;
	}

	public static void sieve(int n) {
		boolean[] visited = new boolean[n + 1];
		Arrays.fill(visited, false);
		visited[0] = true;
		visited[1] = true;
		for (int table = 2; table * table <= n; table++) {
			if (visited[table])
				continue;
			for (int mult = 2; mult * table <= n; mult++) {
				visited[table * mult] = true;
			}
		}
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false)
				System.out.println(i);
		}
	}

	public static int pow(int x, int n) {
		if (n == 0)
			return 1;
		int res = pow(x, n / 2);
		if (n % 2 == 0)
			return res * res;
		else
			return res * res * x;

	}

	public static void transform(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = str.charAt(0);
		String roq=str.substring(1);
		if (Character.isLowerCase(ch) == true) {
			
			transform(roq,ans + Character.toUpperCase(ch) + "");
			transform(roq,ans+ch);
		}
		else if (Character.isUpperCase(ch) == true) {

          transform(roq,ans + Character.toLowerCase(ch) + "");
          transform(roq, ans+ch);
		}
		else if(Character.isDigit(ch))
		{ 
		transform(roq, ans+ch);
		}
		
	}


}

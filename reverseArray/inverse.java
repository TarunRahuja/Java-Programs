package reverseArray;
import java.util.Scanner;
public class inverse {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int [] inv = new int[n];
	int [] arr = new int[n];
	System.out.println("enter array");
	for(int i = 0; i<n; i++)
	{
		arr[i]=sc.nextInt();
	}
	for(int i = 0; i<n;i++)
	{
		inv[arr[i]]=i;
	}
	for(int i = 0; i<n;i++)
	{
		System.out.print(inv[i]+"\t");
	}
	}

}

package day3;
import java.util.Scanner;
public class temperature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int minf = sc.nextInt();
		int maxf = sc.nextInt();
		int step = sc.nextInt();
		int i = minf;
		int temp = 0;
		while(i<=maxf)
		{
			temp = (int)((5.0/9)*(i-32));
			System.out.println(i+"\t"+temp);
			i+=step;
			
		}
	}

}

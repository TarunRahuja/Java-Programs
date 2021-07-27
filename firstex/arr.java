package firstex;

public class arr {

	public static void main(String[] args) {
		int []a=  {10,20,30,40};
		for(int t:a) {
			System.out.println(t);
		}//enhanced for
		String [] str= {"hello","Tarun"};
		for(String t1:str) {
			System.out.println(t1);
		}
		int [][] two= new int[3][3];
		String str1="Tarun";
		System.out.println(str1.toUpperCase());
		System.out.println(str1.substring(2));
		System.out.println(str1.substring(2,4));
		String num="2";
		int n= Integer.parseInt(num);
		System.out.println(n/2);
		

}
}

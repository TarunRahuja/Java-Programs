package fileHandling;
import java.io.*;
import java.io.IOException;
public class FileHandling {

	public static void main(String[] args) throws IOException {
		File f1 = new File("C:/users/tarun/filehandlingexamples/test.txt");
		System.out.println("Does file exist "+f1.exists());
//		System.out.println("File Size: "+f1.length());
//		f1.delete();
		//FileOutputStream fout = new FileOutputStream(f1,true);
//		String str = "Data";
//		char [] s = str.toCharArray();
//		for(int i=0; i<s.length; i++) {
//			fout.write(s[i]);
//		}
//		FileInputStream fin = new FileInputStream(f1);
//		int i = 0;
//		do {
//			i = fin.read();
//			if((i)!=-1) {
//				System.out.print((char)(i));
//			}
//		}while(i!=-1);
//		fin.close();
//		fout.close();
		//BufferedWriter bw = new BufferedWriter(new FileWriter(f1,true));
		//bw.write("Hello");
		//bw.close();
		BufferedReader br = new BufferedReader(new FileReader(f1));
		int i = 0;
//		do {
//			 i = br.read();
//			 if(i!=-1) {
//				 System.out.print((char)i);
//			 }
//		}while(i!=-1);
		//String str = br.readLine();
		//System.out.println(str);
		String str = "";
//		do {
//			str = br.readLine();
//			if(str!=null) {
//				System.out.println(str);
//			}
//		}while(str!=null);
		char [] ch = new char[20];
		br.read(ch,0,4);
		System.out.println(ch);
	}

}

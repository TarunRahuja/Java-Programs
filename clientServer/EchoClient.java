package clientServer;
import java.io.*;
import java.net.*;
import java.util.*;
public class EchoClient {
	public static void main(String[] args) throws Exception {
		System.out.println("Client Started");
		Socket soc = new Socket("localhost",3000);
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a number");
		String str = userInput.readLine();
		int num = Integer.parseInt(str);
		PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
		out.println(num);
	}

}

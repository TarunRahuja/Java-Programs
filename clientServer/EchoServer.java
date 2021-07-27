package clientServer;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
public class EchoServer {
	public static void main(String[] args) throws Exception {
		System.out.println("Waiting for Cients");
		ServerSocket ss = new ServerSocket(3000);
		Socket soc = ss.accept();
		System.out.println("Connection Established");
		BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		int fact = 1;
		int num = Integer.parseInt(in.readLine());
		for(int i=1; i<=num; i++) {
			fact*=i;
		}
		System.out.println(fact);
	}

}

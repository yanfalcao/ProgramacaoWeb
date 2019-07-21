package negocio;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("", 1234);
			Scanner in = new Scanner(client.getInputStream());
			Scanner inUser = new Scanner(System.in);
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);
			System.out.println(in.nextLine());
			
			while (true) {
				System.out.println("Digite um numero: ");
				out.println(inUser.nextLine());
                                System.out.println();
				System.out.println(in.nextLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

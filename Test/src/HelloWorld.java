import java.util.*;
import java.io.*;

class HelloWorld{
	public static void main(String args[]) throws IOException{
		System.out.println("Hello world! Enter a character: ");
		
		
		Scanner sc = new Scanner(System.in);
		char ch = sc.next(".").charAt(0);
		System.out.print(ch);
		
		System.out.println("Enter another character: ");
		Reader reader = new InputStreamReader(System.in);
		int ch1 = reader.read();
		System.out.println(ch1);
		sc.close();
	}
}
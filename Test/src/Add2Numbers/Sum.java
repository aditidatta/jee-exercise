package Add2Numbers;
import java.util.Scanner;
class Sum{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 number:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = a + b;
		System.out.println("Sum: "+sum);
		sc.close();
	}
}
package bank;

public class Bank{
	public static void main(String args[]){
		
	
		System.out.println();
		System.out.println("Savings Account 1");
		System.out.println();
		
		SavingsAccount sac = new SavingsAccount(5000, 12000023,0.01);
		System.out.println("after opening "+sac.getBalance());
		sac.deposit(2000);
		System.out.println("after deposit "+sac.getBalance());
		sac.addInterest();
		System.out.println("after adding interest "+sac.getBalance());
		sac.withdraw(1000);
		System.out.println("after withdraw "+sac.getBalance());
		
		System.out.println();
		System.out.println("Current Account 1");
		System.out.println();
		
		CurrentAccount cac = new CurrentAccount(5000, 22000023,1000);
		System.out.println("after opening "+cac.getBalance());
		cac.deposit(2000);
		System.out.println("after deposit "+cac.getBalance());
		cac.withdraw(1000);
		System.out.println("after withdraw "+cac.getBalance());
		
		System.out.println();
		System.out.println("Current Account 2");
		System.out.println();
		
		CurrentAccount cac1 = new CurrentAccount(5000, 22000024);
		cac1.setOverDraftLimit(500);
		System.out.println("after opening "+cac1.getBalance());
		cac1.deposit(2000);
		System.out.println("after deposit "+cac1.getBalance());
		cac1.withdraw(1000);
		System.out.println("after withdraw "+cac1.getBalance());
	}
}
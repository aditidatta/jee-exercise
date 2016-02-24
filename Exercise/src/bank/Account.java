package bank;

public class Account {
	
	private double balance; // need a constructor to access a private variable
	private int accountNumber;
	
	public Account(){ // you need this constructor to make an object of it using getWhatever method later. 
		balance = 0; // if you dont create this account constructor, java will try to match it with the Account constructor below
		accountNumber = 0; // it will be a mismatch because that constructor has 2 parameters.
	}
	
	public Account(double bal, int an ) {
		this.balance = bal;
		this.accountNumber = an;
	}
	
	
	void deposit(double deposit) { //doesnt need a set because deposit is already a method
		balance = deposit + balance;	
	}
	
	void withdraw(double withdraw) {	
		if (withdraw > balance)
			System.out.println("You cannot over draw your account ");
		else
			balance = balance - withdraw;
	}
	 
	double getBalance() {
		return balance;
	}

	int getAccountNumber() {
		return accountNumber;
	}
	
	// set methods are below
	
	void setBalance(double balance){
		this.balance = balance;
	}
	
	void setAccount(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}



package bank;

public class SavingsAccount extends Account {
	private double interest; // interest rate
	
	public SavingsAccount(double bal, int acn, double i) {
		super(bal, acn);
		interest = i;
	}
	
	void setInterest(double interest) {
		this.interest = interest;
	}
	
	double getInterest() {
		return interest;
	}
	
	double addInterest() {
		double balance = getBalance();
		balance = balance * (1 + interest);
		setBalance(balance);
		return balance;
	}
}
package bank1;

public class SavingsAccount extends Account {
	private double interest; // interest rate
	
	public SavingsAccount(int acn, double i) {
		super(acn);
		interest = i;
	}
	
	void setInterest(double interest) {
		this.interest = interest;
	}
	
	double getInterest() {
		return interest;
	}
	
	void addInterest() {

		double totalInterest = getBalance() * interest;
		deposit(totalInterest);
	}
}
package bank;

public class CurrentAccount extends Account {
	private double overDraftLimit;
	
	public CurrentAccount(double bal, int acn){
		super(bal, acn);
		overDraftLimit = -1;
	}
	
	public CurrentAccount(double bal, int acn, double odl){
		super(bal, acn);
		overDraftLimit = odl;
	}
	
	void setOverDraftLimit(double odl){
		overDraftLimit = odl;
	}
	
	double getOverDraftLimit(){
		return overDraftLimit;
	}
	
	
	void withdraw(double wdAmt){	
		double balance = getBalance();
		if(wdAmt > overDraftLimit){
			System.out.println("greater that over draft limit");
		}
		else{
			balance = balance - wdAmt;
			setBalance(balance);
		}
			
	}
}
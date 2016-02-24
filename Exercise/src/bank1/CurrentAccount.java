package bank1;

public class CurrentAccount extends Account {
	private double overDraftLimit;
	
	public CurrentAccount(int acn){
		super(acn);
		overDraftLimit = -1;
	}
	
	public CurrentAccount(int acn, double odl){
		super(acn);
		overDraftLimit = odl;
	}
	
	public void setOverDraftLimit(double odl){
		overDraftLimit = odl;
	}
	
	public double getOverDraftLimit(){
		return overDraftLimit;
	}
	
	
	public void withdraw(double wdAmt){	
		
		if(wdAmt > overDraftLimit){
			System.out.println("greater that over draft limit");
		}
		else{
			super.withdraw(wdAmt);
			//setBalance(balance);
		}
	
	}
}
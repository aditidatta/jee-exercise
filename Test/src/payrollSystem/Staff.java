package payrollSystem;

class Staff extends Employee implements EmployeeInfo {
	private double hourlyRate;
	//private double monthlyEarning;
	
	public Staff(double hourlyRate, String lastName, String firstName, String idNumber, char sex) {
		super(lastName, firstName, idNumber, sex);
		this.hourlyRate = hourlyRate;
	}
	
	void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	double getHourlyRate() {
		return hourlyRate;
	}
	
	/*public double getMonthlyEarning(){
		return monthlyEarning;
		this get method was making it not work, becase I was returning monthlyEarning in both methods and complier was only taking this one
		this has no calculation
	}*/ 
	
	// override abstract method in this class
	
	public double monthlyEarning() { // abstract method here is the get method in this case
		//double hourlyRate = getHourlyRate(); // this is unneccesary
		return hourlyRate * Monthly_Hours_Worked; // interface to 160 houra
	}
}

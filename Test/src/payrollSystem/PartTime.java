package payrollSystem;


class PartTime extends Staff {
	private int hoursPerWeek;
	
	public PartTime( int hoursPerWeek, double hourlyRate, String lastName, String firstName, String idNumber, char sex ){
		super(hourlyRate, lastName, firstName, idNumber, sex);
		this.hoursPerWeek = hoursPerWeek;
	}	
	
	void setHoursPerWeek(int hoursPerWeek){
		this.hoursPerWeek = hoursPerWeek;
	}	
	
	public int getHoursPerWeek(){
		return hoursPerWeek;
	}

	public double monthlyEarning() { // also overrides abstract method
	
		return getHourlyRate() * hoursPerWeek * 4;
		
		//jsut call method to access this.  this skips some steps
	
	}
	
}

package payrollSystem;


class Faculty extends Employee implements EmployeeInfo  {
	private String level;
	//private double monthlyEarning;
	
	Education edu = new Education("BA", "economics", 2);
	
	public Faculty(String level, String lastName, String firstName, String idNumber, char sex) {
		super(lastName, firstName, idNumber, sex); //passes variables with super class constructor
		this.level = level;
		//monthlyEarning = 5000;
	}
	
	void setLevel(String level){
		this.level = level;
	}
	
	String getLevel() {
		return level;
	}
	
	public double monthlyEarning() { // also overrides abstract method
		double me = 0.0;
		String input = getLevel();
		if ( input == "GRAD")
			me = Faculty_Monthly_Salary; // interface variable
		else if ( input == "ASSOC")
			me = Faculty_Monthly_Salary * 1.2;
		else if ( input == "PROF")
			me = Faculty_Monthly_Salary * 1.4;
		return me;
		// if i put these in reverse, i wouldve had to intialize at 1
		//so month earning wouldnt be at 0, and then 0 * 1.2 would equal 0 instead of 1.2
	}
	
	public String toString(){
		return "ID Employee: " + getIdNumber() + "\n" + "Employee name: " + getFirstName() + " " + getLastName() + "\n" + "sex: " + getSex() + "hours worked: " + 160 + "\n" + "Monthly salary; " + monthlyEarning();  		
	}
}

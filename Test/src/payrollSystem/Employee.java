package payrollSystem;

abstract class Employee implements Comparable<Employee>{
	private String lastName;
	private String firstName;
	private String idNumber;
	private char sex;
	
	public Employee(String lastName, String firstName, String idNumber, char sex) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.idNumber = idNumber;
		this.sex = sex;
	}
	
	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	String getLastName() {
		return lastName;
	}
		
	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	String getFirstName() {
		return firstName;
	}
	
	void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	String getIdNumber() {
		return idNumber;
	}
	
	void setSex(char sex) {
		this.sex = sex;
	}
	
	char getSex(){
		return sex;
	}
	
	public String toString(){
		return "ID Employee: " + idNumber + "\n" + "Employee name: " + firstName + " " + lastName + "\n" + "sex: " + sex;    		
	}
	
	// public abstract double monthlyEarning();
	public abstract double monthlyEarning(); // abstract method.  needs access modifier and return type too
	
	public int compareTo(Employee otherEmp){
		if(this.getIdNumber().compareTo(otherEmp.getIdNumber()) > 0)
			return 1;
		else if(this.getIdNumber().compareTo(otherEmp.getIdNumber()) < 0)
			return -1; 													
		return 0;
	}


}	

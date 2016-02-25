package payrollSystem;

class Education {
	private String degree;
	private String major;
	private int research;
	
	public Education(String degree, String major, int research) {
		this.degree = degree;
		this.major = major;
		this.research = research;
	}
	
	void setDegree(String degree) {
		this.degree = degree;
	}

	String getDegree() {
		return degree;
	}
	
	
	void setMajor(String major) {
		this.major = major;
	}
	
	String getMajor(){
		return major;
	}
	
	void setResearch(int research) {
		this.research = research;
	}
	
	int getReseearch() {
		return research;
	}
	
	
}

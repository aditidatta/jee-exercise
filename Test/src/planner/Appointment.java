package planner;

class Appointment extends Schedule{
	String appointment;
	Appointment(String st, String et, String apmnt){
		super(st,et);
		appointment = apmnt;
	}
	
}
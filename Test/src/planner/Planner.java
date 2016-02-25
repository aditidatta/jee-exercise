package planner;

class Planner{
	static Entry entry;
	static Appointment ap1;
	static Appointment ap2;
	static Schedule day = new Schedule("9:00","17:00",0);
	static Nap nap;
	
	static void init(){
		ap1 = new Appointment(day.startTime,day.startTime,"Work starts");
	}
	
	static void end(){
		ap2 = new Appointment(day.endTime,day.endTime,"Work starts");
	}
	
	static void addAppointment(String st, String et, String name){
		ap2 = new Appointment(st,et,name);
	}
	
	static void setNapSchedule(){
		nap = new Nap(ap1,ap2);
		ap1 = ap2;
	}
	
	
	static void printFunc(String napStartTime, int napTime, int totalFreeTime){
		
		if(napTime < 60)
			System.out.println("You can take longest nap at "+napStartTime+" and it will last for "+napTime+" minutes.");
		else
			System.out.println("You can take longest nap at "+napStartTime+" and it will last for "+napTime/60+" hours "+napTime%60+" minutes ");
		
		totalFreeTime = Planner.day.getFreeTime();
		if(totalFreeTime < 60)
			System.out.println("Total free time during whole day is "+totalFreeTime+" minutes");
		else
			System.out.println("Total free time during whole day is "+totalFreeTime/60+" hours "+totalFreeTime%60+" minutes");
		
	}
}
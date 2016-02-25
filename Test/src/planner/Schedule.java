package planner;

class Schedule{
	String startTime;
	String endTime;
	int freeTime;
	
	Schedule(){
		startTime = "9:00";
		endTime = "17:00";
		freeTime = 17-9;
	}
	
	Schedule(String st, String et){
		startTime = st;
		endTime = et;
		freeTime = 0;
	}
	
	Schedule(String st, String et, int ft){
		startTime = st;
		endTime = et;
		freeTime = ft;
	}
	
	void addFreeTime(int t){
		freeTime = freeTime + t;
	}
	
	int getFreeTime(){
		return freeTime;
	}
}
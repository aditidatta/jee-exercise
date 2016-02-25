package planner;

class Nap extends Schedule{
	int napEndH;
	int napEndM;
	int napStartH;
	int napStartM;
	
	Nap(Appointment ap1, Appointment ap2){
		super(ap1.endTime,ap2.startTime);
		napEndH = Integer.parseInt(super.endTime.substring(0, super.endTime.indexOf(':')));
		napEndM = Integer.parseInt(super.endTime.substring(super.endTime.indexOf(':')+1));
		napStartH = Integer.parseInt(super.startTime.substring(0, super.startTime.indexOf(':')));
		napStartM = Integer.parseInt(super.startTime.substring(super.startTime.indexOf(':')+1));
	}
	
	int calculateNapTime(){
		
		int napTime = (napEndH*60+napEndM) - (napStartH*60+napStartM);
		return napTime;
	}
	
	String getStartTime(){
		return super.startTime;
	}
	
	String getEndTime(){
		return super.endTime;
	}
}
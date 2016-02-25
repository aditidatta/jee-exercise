package planner;

import java.util.Scanner;

class NapTimeCalculator{
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		
		String startTime;
		String endTime;
		
		int napTime = 0;
		int prevNapTime = 0;
		int totalFreeTime = 0;
		
		Planner.init();
		String napStartTime = Planner.day.startTime;
		
		while(true){
			System.out.print("Do you want to add an appointment? [y/n] ");
			String agree = sc.nextLine();
			if(agree.charAt(0) == 'y' || agree.charAt(0) == 'Y'){
				
				System.out.print("Enter starting time: "); 	startTime = sc.nextLine();
				System.out.print("Enter ending time: "); 	endTime = sc.nextLine();
				System.out.print("Enter appointment: "); 	String appointment = sc.nextLine();

			
				Planner.addAppointment(startTime, endTime, appointment);
				Planner.setNapSchedule();
				napTime = Planner.nap.calculateNapTime();
				Planner.day.addFreeTime(napTime);
				
				if(napTime >= prevNapTime){
					prevNapTime = napTime;
					napStartTime = Planner.nap.getStartTime();
				}
			}
			else{
				Planner.end();
				Planner.setNapSchedule();
				napTime = Planner.nap.calculateNapTime();
				Planner.day.addFreeTime(napTime);
				
				if(napTime >= prevNapTime){
					prevNapTime = napTime;
					napStartTime = Planner.nap.getStartTime();
				}
				
				Planner.printFunc(napStartTime, prevNapTime, totalFreeTime);
				break;
			}
		}
			
		
		//System.out.print(napTime);
		sc.close();
	}
}
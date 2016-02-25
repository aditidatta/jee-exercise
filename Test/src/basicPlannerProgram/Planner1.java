package basicPlannerProgram;

import java.util.Scanner;

class Planner1{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		String startTime = "9:00";
		String endTime = startTime;
		
		int napStartH = 9, napStartM = 0, napEndH = 17, napEndM = 0;
		
		int napTime = 0;
		//int napTimeD = (napEndH*60+napEndM) - (napStartH*60+napStartM);
		int prevNapTime = 0;
		int totalFreeTime = 0;
		String startTimeD = startTime;
	
		
		while(true){
			System.out.print("Do you want to add an appointment? [y/n] ");
			String agree = sc.nextLine();
			if(agree.charAt(0) == 'y' || agree.charAt(0) == 'Y'){
				System.out.print("Enter starting time: ");
				startTime = sc.nextLine();
				
				napEndH = Integer.parseInt(startTime.substring(0, startTime.indexOf(':')));
				napEndM = Integer.parseInt(startTime.substring(startTime.indexOf(':')+1));
				
				napTime = (napEndH*60+napEndM) - (napStartH*60+napStartM);
				totalFreeTime = totalFreeTime + napTime;
				
				if(napTime > prevNapTime){
					prevNapTime = napTime;
					startTimeD = endTime;
				}
				
				System.out.print("Enter ending time: ");
				endTime = sc.nextLine();
				napStartH = Integer.parseInt(endTime.substring(0, endTime.indexOf(':')));
				napStartM = Integer.parseInt(endTime.substring(endTime.indexOf(':')+1));
				
				System.out.print("Enter appointment: ");
				//String appointment = sc.nextLine();
					
			}
			
			else{
				napTime = (17*60) - (napStartH*60+napStartM);
				totalFreeTime = totalFreeTime + napTime;
				if(napTime > prevNapTime){
					prevNapTime = napTime;
					startTimeD = endTime;
				}
				if(prevNapTime < 60)
					System.out.println("You can take longest nap at "+startTimeD+" and it will last for "+prevNapTime+" minutes.");
				else
					System.out.println("You can take longest nap at "+startTimeD+" and it will last for "+prevNapTime/60+" hours "+prevNapTime%60+" minutes ");
				
				if(totalFreeTime < 60)
					System.out.println("Total free time during whole day is "+totalFreeTime+" minutes");
				else
					System.out.println("Total free time during whole day is "+totalFreeTime/60+" hours "+totalFreeTime%60+" minutes");
				
				
				break;
				
				
			}
		}
		
		sc.close();
	}
}
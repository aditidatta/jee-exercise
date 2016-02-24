package cis22cHw2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AirportSimulator implements QSimulatorInterface
{
	private LinkedQueue<Event> runwayQueue = new LinkedQueue<>(); // for holding "takeoffs" and "landings"

	private Event runway = new Event(); 
	private double idleTimeTotal;	// accumulator for trafficController's idle time
	private double waitTimeTotal;	// accumulator for planes' wait time
	private int numEvents; 		// number of "planes"
	private double currTime; 	// current time during a simulation
	Scanner infile; 	// file being used for simulation

	public AirportSimulator(){  }
	
	public AirportSimulator(Scanner file)
	{
		infile = file;
	}
	
	public void setInputFile(Scanner file)
	{
		infile = file;
	}
	
	
	public Event readEvent()
	{
		int id;
		double startTime;
		double duration;
		Event event = null;
	
		if (infile == null || !infile.hasNext())
			return null;
	
		try
		{
			id = infile.nextInt();
			startTime = infile.nextDouble();
			duration = infile.nextDouble();
			event = new Event(id, startTime, duration);
		}
		catch( InputMismatchException ioe )
		{
			return null;
		}
		return event;
	}
	
	public void runSimulation()
	{

/*   INITIALIZE all the numeric member variables to 0*/
		idleTimeTotal = 0;	
		waitTimeTotal = 0;	
		numEvents = 0; 		
		currTime = 0; 
	    /*AND all the runway's member's 0*/
		runway.setId(0);
		runway.setStartTime(0);
		runway.setDuration(0);
		System.out.println( "Starting simulation at " + currTime);
		//Assign the return value of getEvent() to a local var.
		Event e = getEvent();
		while(e != null){//Loop while it's not 0
			processEvent(e);//Calling processEvent passing the local var.
			e = getEvent();//Assign the return value of getEvent() to a local var.
		}//end loop
		displayStatistics();//Calling the displayStatistics() function (notice this is AFTER the loop ends)

	
	}

	public Event getEvent()
	{

		//Initialize local Event variables var1 and var2 to null
		Event var1 = null;
		Event var2 = null;
		//IF the runway is processing a plane (runway's ID isn't 0) RETURN runway
		if(runway.getId() != 0)
			return runway;
		//ELSE
		
		else{
			if(!runwayQueue.isEmpty()){		//IF the runwayQueue isn't empty

				var1 = runwayQueue.peekFront(); //Assign the front of the queue to local var1
				runwayQueue.dequeue();			//Dequeue from the runwayQueue
			}
		
			else	var1 = readEvent();//Assign the return value of readEvent() to local var1
			//ENDIF

			var2 = readEvent();//Assign the return value of readEvent() to local var3
			if(var2 != null){//If the local var3 isn't 0:
				runwayQueue.enqueue(var2);//Enqueue local var3
			}//ENDIF

			return var1;//RETURN local var1 (will be 0 if no more Events)
		}//ENDIF
		
	}

	public void processEvent(Event currEvent)
	{

		//IF the currEvent is the runway
		if(currEvent.equals(runway)){
			currTime = runway.getStartTime()+runway.getDuration();//Update the current time to runway's startTime + duration
			if(currEvent.getId() > 0) //if a landing, display 
				System.out.println("Completed landing ID# " + currEvent.getId() + " at " + currTime);
			else if(currEvent.getId() < 0) //if a takeoff, display 
				System.out.println("Completed takeoff ID# " + currEvent.getId() + " at " + currTime);
			//Reset the runways ID to 0 and the runway's startTime to current time
			runway.setId(0);
			runway.setStartTime(currTime);
		}
		else{
			double requestTime = currEvent.getStartTime();//currEvent's startTime here is stored in a local var requestTime
			if(currTime < requestTime)//IF the current time < requestTime, assign the current time to the requestTime 
				currTime = requestTime;
			idleTimeTotal = idleTimeTotal+ currTime - runway.getStartTime();//Adds the difference between current time and runway's "startTime" to the idleTimeTotal
			waitTimeTotal = waitTimeTotal + currTime - currEvent.getStartTime();//Adds the difference between current time and currEvent's "startTime" to the waitTimeTotal

			numEvents++;//Increment numEvents
			//Indicate that the runway is allowing a landing or takeoff:
			//determine if a landing or takeoff
			if(currEvent.getId() > 0) //if a landing, display 
				System.out.println("Starting landing ID# " + currEvent.getId() + " at " + currTime);
			else if(currEvent.getId() < 0) //if a takeoff, display 
				System.out.println("Starting takeoff ID# " + currEvent.getId() + " at " + currTime);
			runway.setId(currEvent.getId());//setting the runway's ID to the currEvent's ID
			runway.setStartTime(currTime);//setting the runway's startTime to the currTime
			runway.setDuration(currEvent.getDuration()); //setting the runway's duration to the currEvent's duration
		}
		 

	}

	public void displayStatistics()
	{


	System.out.println("Ended simulation at " + currTime);
	System.out.println("Total Runway Idle Time: " + idleTimeTotal);
	System.out.println("Number of planes: " + numEvents);
	System.out.println("Total Wait Time: " + waitTimeTotal);
	System.out.println("The average wait time: " + waitTimeTotal/numEvents);

	}
}


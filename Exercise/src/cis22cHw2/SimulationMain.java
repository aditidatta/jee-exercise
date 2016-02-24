package cis22cHw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimulationMain{
	//-----------------------------------------------------------------------------
	
		public static Scanner userScanner = new Scanner(System.in); // opening a Scanner object to take input from console
	
		public static void main(String args[]){
			Scanner infile; // creating a file

			infile = openInputFile(); // opening a file
			if ( infile == null)  //if open was  not successful
			{
				System.out.println("Unable to open input file for testing clone()\n");
				return;
			}
			
			AirportSimulator as = new AirportSimulator(infile); // creating object of AirportSimulator with the file
			as.runSimulation(); // calling runSimulation() method, which runs the simulation
			infile.close(); //closing the file
			System.out.println("\nClone Tester...."); 
			
			cloneTester(); //calling cloneTester() which opens an input file, creates a queue and create a deep copy of it.
		}
		
		public static Scanner openInputFile()
		{
			String filename;
	        	Scanner scanner=null;
	        
			System.out.print("Enter the input filename: ");
			filename = userScanner.nextLine();
	        	File file= new File(filename);

	        	try{
	        		scanner = new Scanner(file);
	        	}// end try
	        	catch(FileNotFoundException fe){
	        	   System.out.println("Can't open input file\n");
	       	    return null; // array of 0 elements
	        	} // end catch
	        	return scanner;
		}


	//-----------------------------------------------------------------------------

	// you MUST call the cloneTester function below, which calls the clearAndDisplayQueue:
		public static void cloneTester()
		{
			LinkedQueue<Event> theQueue = new LinkedQueue<Event>();
			Scanner infile;
			int id;
			double start;
			double dur;

			infile = openInputFile();
			if ( infile == null) // open the same file you used for the simulation
			{
				System.out.println("Unable to open input file for testing clone()\n");
				return;
			}
			while (infile.hasNext())
			{
				id = infile.nextInt();
				start = infile.nextDouble();
				dur = infile.nextDouble();
				theQueue.enqueue(new Event(id, start, dur));
			}
			infile.close();
			
			LinkedQueue<Event> copyQueue = theQueue.deepClone();
			System.out.println( "\nCopied");
			System.out.println( "\nContents of the copy queue:\n");
			clearAndDisplayQueue(copyQueue);
			System.out.println( "\nContents of the source queue:\n");
			clearAndDisplayQueue(theQueue);
			
			

		}

		public static void clearAndDisplayQueue(LinkedQueue<Event> queue)
		{
			Event event;
			int id;
		 
			while (!queue.isEmpty())
			{
				event = queue.peekFront();
				id = event.getId();
				System.out.println( event );
				event.setId(id*10); // shouldn't change output anywhere
				queue.dequeue();
			}
			System.out.println("Queue has been emptied\n");
		}

}
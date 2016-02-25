package test;
import java.util.Scanner;


class CompareInts{
	public static void main(String args[]){
		int count = 0;
	    
	    int num, smallest = 0, secSmallest = 0, largest = 0, secLargest = 0;
	   
	    System.out.println("Enter integers and non-numbers to quit: ");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			
			num = sc.nextInt();
			count++;
			if(count == 1){
				secSmallest = largest = secLargest = smallest = num;
			}
			else if (count == 2){
				if(num > smallest){
	    			largest = num;
	    			secSmallest = num;
	    			//secLargest = smallest;
	    		}
				else{
					smallest = num;
					secLargest = smallest;
					secSmallest = largest;
				}
			}
			else{
		    	if (num < smallest){
		    		secSmallest = smallest;
		    		smallest = num;
				}
				
				else if(num > largest){
					secLargest = largest;
					largest = num;
				}
				
				else if(num > smallest && num < secSmallest)
					secSmallest = num;
				
				else if(num < largest && num > secLargest)
					secLargest = num;
			
				else continue;
			}
			
		}
		
		sc.close();
		
		System.out.println("Smallest :" + smallest);
		System.out.println("Second Smallest :" + secSmallest);
		System.out.println("Second Largest: " + secLargest);
		System.out.println("Largest: " + largest);
	}
}
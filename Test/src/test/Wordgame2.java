package test;

import java.util.Scanner;

class Wordgame2 {
	public static void main (String args[]) {
		Scanner userinput = new Scanner(System.in);
		
		byte player = 1, prevPlayer,  temp;
	
		System.out.print("Player #"+player+": ");
		String s = userinput.nextLine(); 
		int l = s.length(); 
		char lastLetter = s.charAt(l-1);
		char firstLetter; 
		
		prevPlayer = player;
		player = 2;
		
		while(true) {
			System.out.print("Player #"+player+": ");
			s = userinput.nextLine();
			l = s.length(); 
			firstLetter = s.charAt(0);
	
			if ( firstLetter == lastLetter){
				lastLetter = s.charAt(l-1);
				temp = player;
				player = prevPlayer;
				prevPlayer = temp;
			}
			else {
				System.out.println("Congrats to Player #" + prevPlayer + " for winning the game.");
				break;
			}
				
	
		}	
		
		userinput.close();
	}
}
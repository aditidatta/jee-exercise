package nfl1;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		TeamEntry[] teams = new TeamEntry[8];
		
		System.out.println("Enter Teams and their Winning percentage: ");
		for(int i = 0; i < 8; i++){
			teams[i] = new TeamEntry(sc.next(), sc.nextDouble());
		}
		
		Arrays.sort(teams);
		
		for(int i = 0; i < 8; i++){
			System.out.println(teams[i].getName()+ " is ranked "+(i+1));
		}
		
		Player[] players = new Player[32];
		
		System.out.println("Enter Players and their round number: ");
		for(int i = 0; i < 32; i++)
			players[i] = new Player(sc.next(), sc.nextInt());
		
		Arrays.sort(players);
		
		/*for(int i = 0; i < 32; i++){
			System.out.println(players[i].getName()+ " is selected to be drafted in Round "+players[i].getRound());
		}*/
		
		int array[][] = new int[4][8];
		
		for (int round = 1; round<= 4; round++){
			for(int i = 0; i<8; i++){
				for(int j = 0; j<8; j++){
					if(array[round-1][j] == 0)
						System.out.println((j+1)+". "+players[round+j].getName());
					else
						System.out.println((j+1)+". "+players[round+j].getName()+" (already selected)");
				}
				System.out.println(teams[i].getName()+" select the player number: ");
				int pl = sc.nextInt();
				array[round-1][pl-1] = i+1;
			}
			
		}
		sc.close();
	}
}
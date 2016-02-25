package nfl;

import java.util.Scanner;

public class NFLDraft{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Teams teams = new Teams(8);
		System.out.println("Enter Teams and their Winning percentage: ");
		for(int i = 0; i < 8; i++){
			teams.add(sc.next(), sc.nextDouble());
		}
		
		TeamEntry[] sorted = teams.sort();
		
		for(int i = 0; i < 8; i++){
			System.out.println(sorted[i].getName()+ "is ranked "+(i+1));
		}
		
		sc.close();
	}
}
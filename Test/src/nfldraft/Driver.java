package nfldraft;
import java.util.Arrays;
import java.util.Random;

public class Driver {
	public static Random rand = new Random();
	
	
	public static void selection(Team[] teams, Player[] players){
		for(int i = 0; i<8; i++){
			System.out.println("Round :1 Team: " + teams[i].getName() + " selected: " + players[i].getName());
		}
		for(int i = 8,  j =0;  i <16; i++, j++){
			System.out.println("Round :2 Team: " + teams[j].getName() + " selected: " + players[i].getName());
		}
		for(int i = 16, j =0;  i <24; i++, j++){
			System.out.println("Round :3 Team: " + teams[j].getName() + " selected: " + players[i].getName());
		}
		for(int i = 24, j =0;  i <32; i++, j++){
			System.out.println("Round :4 Team: " + teams[j].getName() + " selected: " + players[i].getName());
		}	
	}

	public static Team[] sortTeams(String a[], double b[]){
		Team[] teams = new Team[8];
		for(int i = 0; i < 8; i++){
			teams[i] = new Team(a[i], b[i]);	
		}
		//Display result of winning percentage to team. 
		for(int i = 0; i < 8; i++){
			System.out.println("The " + teams[i].getName() + " won "+ teams[i].getWPer() +" of their games last season!");
		}

		System.out.println("\nAfter sorting the data is: ");
		//sort teams array
		Arrays.sort(teams);//here
		return teams;
	}

	public static Player[] sortPlayers(String a[], int b[]){
		Player[] players = new Player[32];
		for(int i = 0; i < 32; i ++){
			players[i] = new Player(a[i],b[i]);
		}
		//Display empty line
		System.out.println();
		//Display player name and randomly selected round. 
		for(int i = 0; i<32; i++){
			System.out.println(players[i].getName() + " has been selected to be drafted in Round " + players[i].getRound());
		}
		//Display empty line
		System.out.println();
		//sort player array
		Arrays.sort(players);
		return players;
	}
	

	private static void getPlayerRounds(int pRounds[], int rounds[]){
		int i = 0;
		//Assigning rounds{1,2,3,4} randomly to players,
		while(i < rounds.length){
			int count = 0;
			while(count < 8){
				int randPos = rand.nextInt(32);
				if(pRounds[randPos] == 0){
					pRounds[randPos] = rounds[i];
					count++;
				}
				else 
					continue;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		
		//random method
		// percentage array
		double winPercent[] = {71.34, 19.72, 33.71, 47.59, 12.54, 44.19, 52.1, 94.75};
		//team array
		String teamNames[] = {"Dallas Cowboys", "Indianapolis Colts","New Orleans Saints", "Buffalo Bills", 
				"Denver Broncos", "San Francisco 49ers", "Green Bay Packers", "Minnesota Vikings"};
		//player array
		String playerNames[] = {"Tony Romo", "Demaro Murray", "Sam Bradford", "Adrian Peterson", "Landry Jones", "Blake Bell", "Tom Brady", "Roy Finch", 
				"Ryan Broyles", "Trevor Knight", "Peytton Manning", "Eli Manning", "Brett Favre", "Ben Roethlisberger", "Aaron Rodgers", "Joe Flacco",
				"Reggie Bush", "Lance Dunbar", "Toby Gerhart", "Brandon Bostick", "Garrett Celek", "Gabin Escobar", "Anthony Fasano", "Geno Smith", 
				"Drew Brees", "Andrew Luck", "Johny Manziel", "Robert Griffin III", "Jonathan Franklin", "Arian Foster", "Mike Goodson", "Jeff Demps"};
		
		//assigning random winning percentage to each team. 
		for(int roll = 1; roll < 100; roll++){
			++winPercent[rand.nextInt(7)];
		}
		
		int rounds[] = new int[] {1,2,3,4};
		int pRounds[] = new int[32];
		getPlayerRounds(pRounds, rounds);
	
		Team[] sortedTeams = sortTeams(teamNames, winPercent);
		Player[] sortedPlayers = sortPlayers(playerNames, pRounds);
		
		
		//Display team ranking per winning percentage
		for(int j = 0; j < sortedTeams.length; j++){
			System.out.println("The " + sortedTeams[j].getName() + " is ranked " + (j+1));
		}
				
		//Display Team's seleciton per round. 
		selection(sortedTeams, sortedPlayers);
	}
}

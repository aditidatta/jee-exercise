package nfldraft;

public class Player implements Comparable<Player> {
private String pName;//variable declarations
private int round;
	//constructor
	Player(String pn, int r) {
		pName = pn;
		round = r; 
		}
	//get player name method
	public String getName(){
		return pName;
	}
	//get round number method
	public int getRound(){
		return round;
	}
	//toString method to display method
	public String toString(){
		return (pName + " has been selected to be drafted in Round " + round);
	}
	//compare method
	public int compareTo(Player otherPlayer){
		if(this.round> otherPlayer.getRound())
			return 1; 
		else if(this.round < otherPlayer.getRound())
			return -1;
		
		return 0;
	}
	
	}

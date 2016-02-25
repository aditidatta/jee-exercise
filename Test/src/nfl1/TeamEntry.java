package nfl1;

public class TeamEntry implements Comparable<TeamEntry>{
	private String teamName;
	private double winPct;
	//private String[] roster;
	
	public TeamEntry(String t, double p){
		teamName = t;
		winPct = p;
	}
	
	public String getName(){ 
		return teamName; 
	}
	
	public double getWinPct(){ 
		return winPct; 
	}
	
	public String toString(){
		return (teamName + ", " + winPct);
	}
	
	public int compareTo(TeamEntry otherTeam) {
		
		if(this.winPct > otherTeam.getWinPct())
			return 1;
		else if(this.winPct < otherTeam.getWinPct())
			return -1;
		return 0;
	}
}
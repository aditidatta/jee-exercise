package nfl;

public class TeamEntry implements Comparable<TeamEntry>{
	private String team;
	private double perf;
	
	public TeamEntry(String t, double p){
		team = t;
		perf = p;
	}
	
	public String getName(){ 
		return team; 
	}
	
	public double getWinPct(){ 
		return perf; 
	}
	
	public String toString(){
		return (team + ", " + perf);
	}
	
	public int compareTo(TeamEntry otherTeam) {
		
		if(this.getWinPct() > otherTeam.getWinPct())
			return 1;
		else if(this.getWinPct() < otherTeam.getWinPct())
			return -1;
		return 0;
	}
}
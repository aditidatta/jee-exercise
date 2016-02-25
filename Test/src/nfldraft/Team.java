package nfldraft;

public class Team implements Comparable<Team>{
	private String name; //name variables declarations
	private double wPer;
	//constructor
	Team(String n, double wp){
		name = n; 
		wPer = wp;
	}
	//get name method
	public String getName(){
	return name; 
	}
	//get winning percentage method
	public double getWPer(){
		return wPer;
	}
	//toString method to display text. 
	public String toString(){
		return ("The " + name + "won " + wPer + " of their games last season!");
	} 
	//compare method 
	public int compareTo(Team otherTeam){
		if(this.wPer > otherTeam.getWPer())
			return 1; 
		else if(this.wPer < otherTeam.getWPer())
			return -1;
		
		return 0;
	}
}
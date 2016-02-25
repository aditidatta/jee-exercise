package nfl;

public class Teams{
	private int count = 0;
	private TeamEntry teamsArray[];
	
	public Teams(int noOfTeams){
		teamsArray = new TeamEntry[noOfTeams];
	}
	
	public void add(String name, double pctOfWin){
		teamsArray[count] = new TeamEntry(name,pctOfWin);
		count++;
	}
	
	public TeamEntry[] sort(){
		TeamEntry[] copy = teamsArray;
		int l = copy.length;
		for(int i = 1; i < l; i++){
			TeamEntry temp = copy[i];
			int j = i;
			while (j > 0 && copy[j-1].getWinPct() > temp.getWinPct()){
				copy[j] = copy[j-1];
				j--;
			}
			copy[j] = temp;
		}
		
		
		return copy;
	}
	
	public TeamEntry[] returnOrig(){
		return teamsArray;
	}
}
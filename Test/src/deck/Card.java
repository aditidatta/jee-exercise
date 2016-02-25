package deck;

public class Card implements CardInterface{
	private int rank;
	private int suit;
	
	public Card(int r, int s){
		rank = r;
		suit = s;
	}
	
	public void setRank(int r){
		rank = r;
	}
	
	public int getRank(){
		return rank;
	}
	
	public void setSuit(int s){
		suit = s;
	}
	
	public int getSuit(){
		return suit;
	}
	
	public String toString(){
		return ranks[this.rank-1] + ", " + suits[this.suit-1];
	}
}

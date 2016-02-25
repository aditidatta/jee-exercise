package deck1;

public class Card {
	private Rank rank;
	private Suit suit;
	
	public Card(Suit s, Rank r){
		rank = r;
		suit = s;
	}
	
	public void setRank(Rank r){
		rank = r;
	}
	
	public Rank getRank(){
		return rank;
	}
	
	public void setSuit(Suit s){
		suit = s;
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	public String toString(){
		return suit+", "+rank;
	}
}

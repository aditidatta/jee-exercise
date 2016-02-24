package blackjack1;

public class Card  {
	
	private Rank rank; // has to be type rank for the enum
	private Suit suit; // type suit
	
	public Card(Rank rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public String toString(){
		return rank + " of " + suit;
	}
	
	
	
	
}	
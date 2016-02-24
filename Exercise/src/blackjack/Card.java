package blackjack;

public class Card  {
	
	private BlackjackRank rank; // has to be type rank for the enum
	private Suit suit; // type suit
	
	public Card( BlackjackRank rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	void setRank(BlackjackRank rank) {
		this.rank = rank;
	}
	
	BlackjackRank getRank() {
		return rank;
	}
	
	void setSuit() {
		this.suit = suit;
	}
	
	Suit getSuit() {
		return suit;
	}
	
	public String toString(){
		return rank + " of " + suit;
	}
	
	
	
	
}	
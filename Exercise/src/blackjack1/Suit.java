package blackjack1;

public enum Suit {
	Clubs(1), Diamonds(2), Hearts(3), Spades(4);
	
	private int value;
	
	private Suit(int value){
		this.value = value; // current object will refer to each month object as its moving down the array
	}
	
	public int getValue(){
		return value;
	}
	
}
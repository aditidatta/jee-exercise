package cardGame1;

public enum Suit {
	CLUBS(1), DIAMONDS(2), HEARTS(3), SPADES(4);
	
	private int value;
	
	private Suit(int value){
		this.value = value; // current object will refer to each month object as its moving down the array
	}
	
	public int getValue(){
		return value;
	}
}

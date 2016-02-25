package deck1;

public enum Suit{
	
	Clubs(1), Dice(2), Spade(3), Hearts(4);
	
	private int value;
	
	private Suit(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
}
package deck;

import java.util.Random;

public class Deck {
	public static Random rand = new Random();
	
	private Card cards[] = new Card[52];
	
	public Deck(){
		//int i = 0;
		for(int i = 0, suit = 1; suit <= 4; suit++){
			for(int rank = 1; rank <= 13; rank++){
				cards[i] = new Card(rank, suit);
				i++;
			}
		}
	}
	
	public void shuffle(){
		Card temp;
		for(int i = 0; i < 52; i++){
			int randPos = rand.nextInt(52);
			temp = cards[i];
			cards[i] = cards[randPos];
			cards[randPos] = temp;
		}
	}
	
	public void showCards(){
		for(int i = 0; i < 52; i++){
			System.out.println(cards[i].toString());
		}
	}
	
}

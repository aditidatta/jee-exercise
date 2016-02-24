package cardGame1;

import java.util.Random;

public class Deck {
	static Random rand = new Random();
	Card[] deck = new Card[52];
	private int top;
	
	
	public void shuffle(){
		top = 51;
		int j= 0;
		for (Suit s: Suit.values()) { 
			for (Rank r: Rank.values()){ 
			deck[j++] = new Card(r, s);
			}
		}	
		
		for(int i = 0; i<deck.length; i++){
			int index = rand.nextInt(52);
			
			Card temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
		
		
	}
	
	public Card deal(){
		return deck[top--];
	}
	
	public void print(){
		for(int i = 0; i<deck.length; i++){
			System.out.println(deck[i]);
		}
	}
}

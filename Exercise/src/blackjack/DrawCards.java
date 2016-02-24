package blackjack;

import java.util.Scanner;

public class DrawCards {
	public static void main (String args[]) {
		
		Deck deck = new Deck();
		deck.shuffle();
		
		
		Scanner sc = new Scanner(System.in);
		String input = " ";
		
		while( true ) {
			
			System.out.println("press d to draw a card, s to shuffle, or q to quit. ");
			input = sc.next();
			if (input.equals("d")){
				if(deck.getSize()>0){				
				//for(int i = 0; i < 52; i++){ // will decrease the deck by one each loop
					Card card = deck.draw(0); // card at position 24 is taken from deck object using draw method
					deck.putIntoPile2(card); // position 24 card is saved to card variable and is passed to pile 2
					System.out.println(card);
				} 
				else
					System.out.println("There are no more cards left in the deck.");
			}	
			else if(input.equals("s")){
				deck.mergePiles();
				deck.shuffle();
			}
			
			else if(input.equals("q")) {
				break;	
			}

			System.out.println("Cards left in the deck is " + deck.getSize());
		}
		
		
		
		
		//for(int i = 0; i < 52; i++) {
		//System.out.println(deck.getCard(i));
		//}
	}	
}



// while there are still cards in the deck and you say draw or you say shuffle
// press keyh to draw card or shuffle
// while input is d, draw cards or s is shuffle
package blackjack;

import java.util.Scanner;

class Blackjack {
	public static void main (String args[])  {
		
		Scanner sc = new Scanner(System.in);
		
		
		Deck deck = new Deck();
		deck.shuffle();
		
	
		//just created deal method
		// deal two cards to each now
		Card playerCard1 = deck.deal();
		Card dealerCard1 = deck.deal();
		Card playerCard2 = deck.deal();
		Card dealerCard2 = deck.deal();
		
		System.out.println(" Your cards are the " + playerCard1 + " and the " + playerCard2);
		System.out.println(" The dealer's face up card is the " + dealerCard1);
		// one of the dealers cards is face down
		
		//int playerTotal = deck.deal() + deck.deal();
		
		System.out.println(playerCard1.getRank().getValue()); // goes back to card class, then enum
		
		int playerHand = playerCard1.getRank().getValue() + playerCard2.getRank().getValue();
		int dealerHand = dealerCard1.getRank().getValue() + dealerCard2.getRank().getValue();
		
		if (playerHand == 21){
			
			System.out.println(" Reveal hole card? Press enter to reveal card. ");
			sc.next();
			
			System.out.println(dealerCard2);
			if (dealerHand == 21){
				System.out.println(" Dealer wins");
			}
			else
				System.out.println(" Player wins");
			
		}
		
		else {
			System.out.println(" ");
		}			
		
		
		
		
	}
}
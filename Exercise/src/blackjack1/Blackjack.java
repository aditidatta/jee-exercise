package blackjack1;
import java.util.Scanner;

class Blackjack {
	static Scanner sc = new Scanner(System.in);
	
	public static void stand(){
		
	}
	
	public static void hit(){
		
	}
	
	public static void main (String args[])  {
		
		
		int numAces1 = 0;
		int numAces2 = 0;
		
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
		
		if(playerCard1.getRank().getValue() == 11) {
			numAces1++;
		}
		
		if(playerCard2.getRank().getValue() == 11) {
			numAces1++;
		}
		
		if(dealerCard1.getRank().getValue() == 11) {
			numAces2++;
		}
		
		if(dealerCard2.getRank().getValue() == 11) {
			numAces2++;
		}
		
		if (playerHand == 21){
			
			System.out.println(" Reveal hole card? Press enter to reveal card. ");
			String input2 = sc.next();
			
			System.out.println(dealerCard2);
			
			if (dealerCard1.getRank().getValue() < 10 ){
				System.out.println(" Player wins");
			}
			
			else if (dealerHand == 21){
				System.out.println(" Dealer wins");
			}
			else
				System.out.println(" Player wins");
			
		}
		
		
		else {
		
			if (playerHand > 21){
				playerHand = 12;
				numAces1--;
			}
			
		while (true){
			System.out.println(" [H]it or [S]tand?");
			char input = sc.next().charAt(0);
		
			
			if (input == 's' || input == 'S'){
				System.out.println(" Reveal hole card? Press enter to reveal card. ");
				String input2 = sc.next();
				
				System.out.println(dealerCard2);
				
				if (dealerHand > 21){
					dealerHand = 12;
					numAces2--;
				}
				while( dealerHand < playerHand && dealerHand < 17) {
					
					Card dealerCard = deck.deal();
					System.out.println(dealerCard);
					dealerHand = dealerHand + dealerCard.getRank().getValue();
					
					if (dealerCard.getRank().getValue() == 11) // if dealers is hitting and draws an ace
						numAces2++;   // increase ace counter
					
					if (dealerHand > 21 && numAces2 > 0){ // check if the dealers hand has any aces if the hand goes over 21
						dealerHand = dealerHand - 10; // 
						numAces2--;
					}
						
				}
				if (dealerHand > 21){
					System.out.println(" Player wins");
				}
				else if(playerHand > dealerHand){
					System.out.println(" Player wins");
				}
				else if (dealerHand > playerHand ){
					System.out.println(" Dealer wins");
				}
				else
					System.out.println(" Dealer wins");
				break;
			}
			
			else if (input == 'h' || input == 'H'){
				Card playerCard = deck.deal();
				System.out.println(playerCard);
				playerHand = playerHand + playerCard.getRank().getValue();
				
				if (playerCard.getRank().getValue() == 11)
					numAces1++;
				
				if (playerHand > 21 ){
					if(numAces1 > 0){
						playerHand = playerHand - 10;
						numAces1--;
					}
					else
						System.out.println(" Dealer wins");	
				}
				
			}
		}			
			
	}
}
}
package cardGame1;


public class Driver {
	
	static LinkedList<Card> player1 = new LinkedList<>();
	static LinkedList<Card> player2 = new LinkedList<>();
	static LinkedList<Card> table = new LinkedList<>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck deck = new Deck();
		
		deck.shuffle();
		//deck.print();
		
		
		for(int i = 0; i<26; i++){
			player1.addFirst(deck.deal());
			player2.addFirst(deck.deal());
		}
		
		
		playGame();
		
		
		System.out.println("\n---------- At the End -----------\n");
		System.out.println("player1 hand size: "+ player1.size);
		System.out.println("player2 hand size: "+ player2.size);
		System.out.println();
		System.out.println("------------ winner ------------");
		
		
		if(player1.size > player2.size)
			System.out.println("Player 1 wins");
		else if(player2.size > player1.size)
			System.out.println("Player 2 wins");
		else
			System.out.println("it's a tie");
	}
	
	
	static void playGame(){
		
		//initrializing round and turn
		int round = 1;
		int turn = 1;
		Card playedCard;
		Card prevCard;
		
		while(round <= 10){
			System.out.println("\n---------round "+ round + "-----------\n");
			int j = turn;	//determining whose turn to start the round with;
			
			if(turn == 1){	
				playedCard = player1.removeFirst();
				System.out.println("Player 1 played " + playedCard);
			}
			else {
				playedCard = player2.removeFirst();
				System.out.println("Player 2 played " + playedCard);
			}
			
			table.addFirst(playedCard);
			prevCard = playedCard;
			while(true){
				
				turn = (j % 2) + 1; //determining turns
				j++;
				
				if(turn == 1){	
					playedCard = player1.removeFirst();
					System.out.println("Player 1 played " + playedCard);
				}
				else {
					playedCard = player2.removeFirst();
					System.out.println("Player 2 played " + playedCard);
				}
				
				table.addFirst(playedCard);
				if(playedCard.getSuit() == prevCard.getSuit()){
					System.out.println("Player "+ turn +" wins the round "+ round);
					//System.out.println("table size: "+ table.size);
					retrieveCards(turn);
					
					break;
				}
				
				prevCard = playedCard;
				
			}
			
			/*System.out.println();
			System.out.println("player1 hand size: "+ player1.size);
			System.out.println("player2 hand size: "+ player2.size);
			*/
			
			if(player1.size == 52 || player2.size == 52){
				break;
			}
			round++;
		}
	}
	
	
	static void retrieveCards(int turn){
		if(turn == 1){
			player1.getItems(table);
		}
		else if(turn == 2){
			player2.getItems(table);	
		}
	}

}

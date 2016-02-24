package blackjack;

import java.util.Random;

class Deck {
		//Staff s[] = new Staff[2];
		
		private Card pile1[] = new Card[52];
		private Card pile2[] = new Card[52]; // 2nd pile of cards that used cards go into
		
		private int size;
		
		private int top = -1; // array starts at -1, makes it null, top represents the position of the last card in pile 2
		
		public Deck(){
			int i = 0;
			size = 52;
			//for (int s = 0; s < 4; s++) old way to do it
			for (Suit s: Suit.values()) { // saves  you writing a line
				for (BlackjackRank r: BlackjackRank.values()){ 
				//for (int r = 0; r < 13; r++) {			
		
				pile1[i] = new Card (r, s); // makes the cards
				i++;
				}
			}
		}
		
		void putIntoPile2(Card card){ // data type, object
			top++; // stars the array because it moves it from -1 to 0
			pile2[top] = card; 	
		}
		
		void mergePiles() { // shuffles two piles back together
			for(int i = 0; i <= top; i++ ) {
				pile1[size++] = pile2[i];
			}
			top = -1;
		/*while(top > -1) { another way to do it
			pile1[size++] = pile2[top--];
		}*/
		
		}
		
		
		
		public Card getCard(int position){ // sends a card to the draw main method
			return pile1[position];
		}
		
		public Card draw(int position){ // there has to be a parameter here so you can call it later
			
			Card temp = pile1[position];
			for(int i = position; i < 52-1-(top+1); i++){ // has to be 52 - 1 or else it will be array index out of bounds
				pile1[i] = pile1[i+1]; // - top to reduce unneccesary loops, top+1 because the array position is one less than the element number
				pile1[i+1] = null; // shrinks deck
				
				
			}
			size--;
			return temp; // shows card you just drew
		}
		public Card deal(){
			size--;  // reduces size of deck
			return pile1[size]; // returns array of pile1 with the position of size, which is now one smaller
		}
		
		
		public int getSize(){
			return size;
		}
		
		
		
		// String suit[] = new String[]{"Spades", "Clubs", "Diamonds", "Hearts"};
		// Suit suit[] = Suit.values(); could have saved it to array
		//String rank[] = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		
			
	public void shuffle(){
		Random rand = new Random();
		
		for (int i = 0; i < 52; i++) {
			int randomPosition  = rand.nextInt(52);
			Card temp = pile1[i];
			pile1[i] = pile1[randomPosition];
			pile1[randomPosition] = temp;
		}			
	}
	
	
	
	
	
}// shuffle method
// java random method from 0-51.  assign number to each card object
// if the number has already been assigned, re loop it
// assign output to a variable
// if card[a] != null (if the position is taken already)

/*
		c[0] = new card ( "Ace", "Spades");
		c[1] = new card ( "2", "Spades");
		c[2] = new card ( "3", "Spades");
		c[3] = new card ( "4", "Spades");
		c[4] = new card ( "5", "Spades");
		c[5] = new card ( "6", "Spades");
		c[6] = new card ( "7", "Spades");
		c[7] = new card ( "8", "Spades");
		c[8] = new card ( "9", "Spades");
		c[9] = new card ( "10", "Spades");
		c[10] = new card ( "Jack", "Spades");
		c[11] = new card ( "Queen", "Spades");
		c[12] = new card ( "King", "Spades");
		c[13] = new card ( "Ace", "Hearts");
		c[14] = new card ( "2", "Hearts");
		c[15] = new card ( "3", "Hearts");
		c[16] = new card ( "4", "Hearts");
		c[17] = new card ( "5", "Hearts");
		c[18] = new card ( "6", "Hearts");
		c[19] = new card ( "7", "Hearts");
		c[20] = new card ( "8", "Hearts");
		c[21] = new card ( "9", "Hearts");
		c[22] = new card ( "10", "Hearts");
		c[23] = new card ( "Jack", "Hearts");
		c[24] = new card ( "Queen", "Hearts");
		c[25] = new card ( "King", "Clubs");
		c[26] = new card ( "Ace", "Clubs");
		c[27] = new card ( "2", "Clubs");
		c[28] = new card ( "3", "Clubs");
		c[29] = new card ( "4", "Clubs");
		c[30] = new card ( "5", "Clubs");
		c[31] = new card ( "6", "Clubs");
		c[32] = new card ( "7", "Clubs");
		c[33] = new card ( "8", "Clubs");
		c[34] = new card ( "9", "Clubs");
		c[35] = new card ( "10", "Clubs");
		c[36] = new card ( "Jack", "Clubs");
		c[37] = new card ( "Queen", "Clubs");
		c[38] = new card ( "King", "Clubs");
		c[39] = new card ( "Ace", "Diamonds");
		c[40] = new card ( "2", "Diamonds");
		c[41] = new card ( "3", "Diamonds");
		c[42] = new card ( "4", "Diamonds");
		c[43] = new card ( "5", "Diamonds");
		c[44] = new card ( "6", "Diamonds");
		c[45] = new card ( "7", "Diamonds");
		c[46] = new card ( "8", "Diamonds");
		c[47] = new card ( "9", "Diamonds");
		c[48] = new card ( "10", "Diamonds");
		c[49] = new card ( "Jack", "Diamonds");
		c[50] = new card ( "Queen", "Diamonds");
		c[51] = new card ( "King", "Diamonds");
		}
		*/
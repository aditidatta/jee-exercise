package deck;



public class Simulation {
	public static void main(String args[]){
		Deck deck1 = new Deck();
		
		deck1.shuffle();
		
		/*for(Rank r: Rank.values()){
	        System.out.println("Rank: " + r.getValue());
		}*/
		
		deck1.showCards();
		
	}
}

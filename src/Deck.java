import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
	}
	
	public void createDeck() {
		for(Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				this.cards.add(new Card(suit, rank));
			}
		}
	}
	
	public void shuffle() {
		List<Card> tempDeck = new ArrayList<>();
		int randomIndex = 0;
		Random rand = new Random();
		int originalSize = this.cards.size();
		
		for(int i = 0; i < originalSize; i++) {
			randomIndex = rand.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
			tempDeck.add(this.cards.get(randomIndex));
			this.cards.remove(randomIndex);
		}
		
		this.cards = tempDeck;
	}
	
	public Card getCards(int i){
		return cards.get(i);
	}
	
	public void removeCard() {
		cards.remove(0);
	}
	
	
	public String toString() {
		String cardType = "";
		int i = 0;
		
		for(Card card : cards) {
			cardType += i + " " + card.getRank() + " of " + card.getSuit() + " value is: " + card.getCardValue() + "\n";
			i++;
		}
		
		return cardType;
	}
}

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	
	private Deck deck;
	private List<Card> hand;
	
	public Dealer(Deck deck) {
		hand = new ArrayList<>();
		this.deck = deck;
	}
	
	public void getCardFromDeck() {
		hand.add(deck.getCards(0));
		deck.removeCard();
	}
	
	public int getValueFromHand() {
		int value = 0;
		for(int i = 0; i < hand.size(); i++) {
			value += hand.get(i).getCardValue();
			
			if(value < 10 && hand.get(i).getRank() == Rank.ACE) {
				value += 10;
			}
		}
		
		return value;
	}
	
	public int getValueOfFirstCard() {
		return hand.get(0).getCardValue();
	}
	
	public Card getCard(int index) {
		return this.hand.get(index);
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public void removeHand() {
		
		hand.removeAll(hand);
	}
	
	public String toString() {
		String cardType = "";
		
		
		for(Card card : hand) {
			cardType += card.getRank() + " of " + card.getSuit() + "\n";
		}
		
		return  cardType;
	}
	
}

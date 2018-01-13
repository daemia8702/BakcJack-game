import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> hand;
	private Deck deck;
	private int money;
	
	
	
	public Player(Deck deck) {
		hand = new ArrayList<>();
		this.deck = deck;
		this.money = 100;	
	}
	
	public void getCardsFromDeck() {
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
	
	public int getMoney() {
		return this.money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public Card getCard(int index) {
		return this.hand.get(index);
	}
	
	public void removeHand() {
		
		hand.removeAll(hand);
	}
	
	public String toString() {
		String cardType = "";
		
		
		for(Card card : hand) {
			cardType += card.getRank() + " of " + card.getSuit() + "\n";
		}
		
		return cardType + "with the total value of: " + getValueFromHand();
	}
	
}

import java.util.Scanner;

public class MainTest {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		Deck deck = new Deck();
		deck.createDeck();
		deck.shuffle();
		Player player = new Player(deck);
		Dealer dealer = new Dealer(deck);
		
		
		int playerMoney = player.getMoney();
		boolean running = true;
		boolean endRound = false;
		
		
		System.out.println("Welcome to my BlackJack Game!!");
		
		
		//Game loop
		while(running) {
			

			System.out.println("How much money do you want to bet? You have a total money of: " + playerMoney + "$");
			int bet = scanner.nextInt();
			if(bet > playerMoney) {
				System.out.println("You don't have enough money to play at this table!! BYEEEE MOTHERFUCKER!!!!");
				break;
			}
			
			System.out.println("Drawing cards....");
			
			int numberOfDrawing = 0;
			
			while(numberOfDrawing < 2) {
				player.getCardsFromDeck();
				dealer.getCardFromDeck();
				numberOfDrawing++;
			}
			
			System.out.println("You have:\n" + player);
			System.out.println("\nDealer has:\n" + dealer.getCard(0).toString() + " and [HIDDEN]. With the total value of: " + 
			dealer.getValueOfFirstCard() + "\n");
			
			while(!endRound) {
				
				System.out.println("Do you want to hit(1) or stand(2)?");
				int response = scanner.nextInt();
				
				if(response == 1) {
					player.getCardsFromDeck();
					System.out.println("You now have:\n" + player + " in your hand.");
					
					if(player.getValueFromHand() > 21) {
						System.out.println("\t------BUST------");
						System.out.println("Dealer had:\n" + dealer + "with the total value of: " + dealer.getValueFromHand());
						playerMoney -= bet;
						player.removeHand();
						dealer.removeHand();
						endRound = true;
						}
						else if(player.getValueFromHand() == 21) {
							System.out.println("You Win!!!");
							System.out.println("Dealer had:\n" + dealer + "with the total value of: " + dealer.getValueFromHand());
							playerMoney += bet;
							player.removeHand();
							dealer.removeHand();
							endRound = true;
						}
					}
				else if(response == 2) {
					if(player.getValueFromHand() > dealer.getValueFromHand()) {
						System.out.println("You win!");
						System.out.println("Dealer had:\n" + dealer + "with the total value of: " + dealer.getValueFromHand());
						playerMoney += bet;
						player.removeHand();
						dealer.removeHand();
						endRound = true;
					}else {
						System.out.println("You lost..");
						playerMoney -= bet;
						System.out.println("Dealer had:\n" + dealer + "with the total value of: " + dealer.getValueFromHand());
						player.removeHand();
						dealer.removeHand();
						endRound = true;
					}
				}
				
			}//while(!endRound)
			
			System.out.println("You now have " + playerMoney + "$");
			
			if(playerMoney == 0) {
				System.out.println("You've lost all of your money! Bye...");
				running = false;
			}
			else if(playerMoney > 0) {
				System.out.println("Do you want to play again? Yes(1); Quit(2)");
				int playAgain = scanner.nextInt();
				
				if(playAgain == 2) {
					System.out.println("Bye...");
					running = false;
				}
				else {
					endRound = false;
				}
			}
		}
	}
	
}

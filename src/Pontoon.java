import java.util.ArrayList;
import java.util.Scanner;

public class Pontoon {
    private Deck dealersDeck = new Deck();
    private int cardCount = 0;
    private Scanner getInput = new Scanner(System.in);
    //private Hand playerHand = new Hand();

    public Pontoon(){
        dealersDeck.addsToDeck();
        dealersDeck.betterShuffle();
        //dealersDeck.displayDeck();
    }

    public void run(int players){
        Hand playerHand = new Hand("Player");
        Hand houseHand = new Hand("House");

        boolean stand = false;

        //gives initial cards to player and house
        for (int i = 0; i< 2; i++) {
            playerHand.add(deal());
            houseHand.add(deal());
        }

        //Hand("House").add

        System.out.println("You have: "+ playerHand.get(0) + ", " + playerHand.get(1));
        System.out.println("The house has: "+ houseHand.get(0) + ",  (CARD)");
        
        while ((playerHand.getHandValue() < 21 && playerHand.getHandValue() < 21) && !stand){
            //asks user if they wish to hit or stand
            System.out.println("Hit or Stand? (h or s)");
            String choice = getInput.nextLine();

            if (choice.equals("h")){ //player hits
                playerHand.add(deal());
                //now the house
                houseHand.add(deal());

                playerHand.show();

                //house shows the first card, not the rest
                System.out.print(houseHand.get(0));
                for (int i =1; i<houseHand.size(); i++){
                    System.out.print(" (CARD)");
                }
                System.out.println();

            } else{
                stand = true;
                while (houseHand.getHandValue() <= playerHand.getHandValue()){
                    houseHand.add(deal());
                }

                //Hand(houseHand);
                //System.out.println("Value of: " + getHandValue(houseHand));
            }
        }

        if (houseHand.getHandValue()> 21 && (playerHand.getHandValue() < 21)){
            System.out.println("User wins");
        } else if (getHandValue(playerHand) == 21 && getHandValue(houseHand) != 21){
            System.out.println("user wins");
        } else{
            System.out.println("The house wins");
        }

        System.out.println();

        System.out.println("You had:");
        playerHand.show();

        System.out.println("The house had: ");
        houseHand.show();
    }

    //player wants a new card
    public Card deal(){
        if (cardCount>=dealersDeck.length()-1){
            dealersDeck.addsToDeck();
            dealersDeck.betterShuffle();
        }

        Card nextCard = dealersDeck.dealCardN(cardCount);
        cardCount ++;
        
        return nextCard;
    }

    
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Pontoon {
    private Deck dealersDeck = new Deck();
    private int cardCount = -1;
    private Scanner getInput = new Scanner(System.in);

    public Pontoon(){
        dealersDeck.addsToDeck();
        dealersDeck.shuffle();
    }

    public void run(int players){
        ArrayList<Card> houseCards = new ArrayList<>();
        ArrayList<Card> playerCards = new ArrayList<>();

        //gives initial cards to player and house
        for (int i = 0; i< 2; i++) {
            playerCards.add(hit());
            houseCards.add(hit());
        }

        System.out.println("You have: "+ playerCards.get(0) + ", " + playerCards.get(1));
        System.out.println("The house has "+ houseCards.get(0) + ",  (CARD)");

        while (getHandValue(playerCards) < 21 && (getHandValue(houseCards) < 21 || getHandValue(houseCards) < getHandValue(playerCards))){
            //asks user if they wish to hit or stand
            System.out.println("Hit or Stand? (h or s)");
            String choice = getInput.nextLine();

            if (choice.equals("h")){ //player hits
                playerCards.add(hit());
                //now the house
                houseCards.add(hit());

                System.out.println("You have : ");
                displayAllCards(playerCards);

                System.out.println("The house has: ");
                System.out.print(houseCards.get(0));
                for (int i =1; i<houseCards.size(); i++){
                    System.out.print(" (CARD)");
                }
                System.out.println();

            } else{//player stands
                //PLAYER STANDS, house adds cards until its greater than value of playerCards
                while (getHandValue(houseCards) <= getHandValue(playerCards)){
                    houseCards.add(hit());
                }

                displayAllCards(houseCards);
                System.out.println("Value of: " + getHandValue(houseCards));
            }
        }

        if (getHandValue(houseCards) > 21 && getHandValue(playerCards) < 21){
            System.out.println("User wins");
        } else if (getHandValue(playerCards) == 21 && getHandValue(houseCards) != 21){
            System.out.println("user wins");
        } else{
            System.out.println("The house wins");
        }

        System.out.println();

        System.out.println("You had:");
        displayAllCards(playerCards);

        System.out.println("The house had: ");
        displayAllCards(houseCards);

    }

    public void displayAllCards(ArrayList<Card> hand){
        for (int i = 0; i<hand.size(); i++){
            System.out.print(hand.get(i) +" ");
        }
        System.out.println();
    }
    //player wants a new card
    public Card hit(){
        cardCount ++;
        return dealersDeck.dealCardN(cardCount);
    }

    //gets the value of a hand
    public int getHandValue(ArrayList<Card> hand){
        int handValue = 0;
        int aceCount = 0;

        //adds each cards value to find the hand value
        for (Card card : hand) {
            if (card.getNumberValue() > 10) {
                handValue = handValue + 10;
            } else if (card.getNumberValue() == 1) {
                handValue = handValue + 11;

                aceCount++;
            } else {
                handValue = handValue + card.getNumberValue();
            }
        }

        while (aceCount > 0 && handValue > 21){
            handValue = handValue - (10);

            aceCount--;
        }
        return handValue;
    }
}

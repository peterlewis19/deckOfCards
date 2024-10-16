import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Pontoon {
    private Deck dealersDeck = new Deck();
    private int cardCount = -1;
    private int turnCount = 1;
    private Scanner getInput = new Scanner(System.in);
    private int standCount = 0;
    private boolean bothStand = false;

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
        System.out.println("The house has "+ houseCards.get(0) + ",  (" + houseCards.get(1) + ")");

        while (getHandValue(playerCards) < 21 && getHandValue(houseCards) < 21){
            //asks user if they wish to hit or stand
            System.out.println("Hit or Stand? (h or s)");
            String choice = getInput.nextLine();

            //hit/stand
            turnCount++;

            if (choice.equals("h")){ //player hits
                playerCards.add(hit());
                //now the house
                houseCards.add(hit());
            } else{//player stands
                standCount ++;
                //PLAYER STANDS, house adds cards until its greater than value of playerCards
                while (getHandValue(houseCards) <= getHandValue(playerCards)){
                    houseCards.add(hit());

                    for (int i = 0; i<=turnCount; i++){
                        System.out.print(houseCards.get(i) +" ");
                    }
                    System.out.println("Value of: " + getHandValue(houseCards));

                    turnCount++;
                }
            }

            //users Cards
            System.out.println("You have : ");
            for (int i = 0; i<playerCards.size(); i++){
                System.out.print(playerCards.get(i) +" ");
            }
            System.out.println("Value of: " + getHandValue(playerCards));

            //the houses cards

            System.out.println("The house has: ");
            System.out.print(houseCards.get(0));

            for (int i = 1; i<houseCards.size(); i++){
                System.out.print("(" + houseCards.get(i) +") ");
            }
            System.out.println("Value of: " + getHandValue(houseCards));
        }

        if (getHandValue(houseCards) > 21 && getHandValue(playerCards) < 21){
            System.out.println("User wins");
        } else if (getHandValue(playerCards) == 21 && getHandValue(houseCards) != 21){
            System.out.println("user wins");
        } else{
            System.out.println("The house wins");
        }

    }

    //player wants a new card
    public Card hit(){
        cardCount ++;
        return dealersDeck.dealCardN(cardCount);
    }

    //gets the value of a hand
    public int getHandValue(ArrayList<Card> hand){
        int handValue = 0;

        //adds each cards value to find the hand value
        for (Card card : hand) {
            if (card.getNumberValue() > 10) {
                handValue = handValue + 10;
            } else if (card.getNumberValue() == 1) {
                handValue = handValue + 11;
                while (handValue > 21) {
                    handValue = handValue - 10;
                }
            } else {
                handValue = handValue + card.getNumberValue();
            }
        }
        return handValue;
    }
}

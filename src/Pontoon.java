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
        Card[] houseCards = new Card[11];

        Card[] userCards = new Card[11];

        //gives initial cards to player and house
        userCards[0] =  hit();
        houseCards[0] = hit();
        userCards[1] = hit();
        houseCards[1] = hit();

        System.out.println("You have: "+ userCards[0] + ", " + userCards[1]);
        System.out.println("The house has "+ houseCards[0] + ",  (" + houseCards[1] + ")");

        while (getHandValue(userCards) <= 21 && getHandValue(houseCards) <= 21){
            //asks user if they wish to hit or stand
            System.out.println("Hit or Stand? (h or s)");
            String choice = getInput.nextLine();

            //hit/stand
            turnCount++;

            if (choice.equals("h")){ //player hits
                userCards[turnCount] = hit();
                //now the house
                houseCards[turnCount] = hit();
            } else{//player stands
                standCount ++;

                //int houseCardStanding = turnCount;
                while (getHandValue(houseCards) <= 21 && getHandValue(houseCards) <= getHandValue(userCards)){
                    houseCards[turnCount+1] = hit();

                    //System.out.println("The house has: ");
                    for (int i = 0; i<=turnCount; i++){
                        System.out.print(houseCards[i] +" ");
                    }
                    System.out.println("Value of: " + getHandValue(houseCards));

                    turnCount++;
                }
            }

            //users Cards
            System.out.println("You have : ");
            for (int i = 0; i<=turnCount; i++){
                System.out.print(userCards[i] +" ");
            }
            System.out.println("Value of: " + getHandValue(userCards));

            //the houses cards

            System.out.println("The house has: ");
            for (int i = 0; i<=turnCount; i++){
                System.out.print(houseCards[i] +" ");
            }
            System.out.println("Value of: " + getHandValue(houseCards));
        }

        if (getHandValue(houseCards) > 21 && getHandValue(userCards) < 21){
            System.out.println("User wins");
        } else if (getHandValue(userCards) == 21 && getHandValue(houseCards) != 21){
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
    public int getHandValue(Card[] hand){
        int handValue = 0;

        //adds each cards value to find the hand value
        for (int i=0; i<=turnCount; i++){
            if (hand[i].getNumberValue() > 10) {
                handValue = handValue+ 10;
            } else if(hand[i].getNumberValue() == 1){
                handValue = handValue + 11;
                while (handValue >= 21){
                    handValue = handValue-10;
                }
            } else{
                handValue = handValue + hand[i].getNumberValue();
            }
        }

        return handValue;
    }
}

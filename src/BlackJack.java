import java.util.Scanner;

public class BlackJack {
    private final Deck dealersDeck = new Deck();
    private int cardCount = 0;
    private final Scanner getInput = new Scanner(System.in);

    public BlackJack(){
        dealersDeck.addsToDeck();
        dealersDeck.betterShuffle();
    }

    public void run(){
        Hand playerHand = new Hand("Player");
        Hand houseHand = new Hand("House");

        boolean stand = false;

        //gives initial cards to player and house
        for (int i = 0; i< 2; i++) {
            playerHand.add(deal());
            houseHand.add(deal());
        }

        playerHand.show();
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
                for (int i = 1; i< houseHand.size(); i++){
                    System.out.print(" (CARD)");
                }
                System.out.println();

            } else{
                stand = true;
                while (houseHand.getHandValue() <=16 || houseHand.getHandValue() <= playerHand.getHandValue()){
                    houseHand.add(deal());
                }
            }
        }

        if (houseHand.getHandValue()> 21 && (playerHand.getHandValue() < 21)){
            System.out.println("User wins");
        } else if (playerHand.getHandValue() == 21 && houseHand.getHandValue() != 21) {
            System.out.println("user wins");
        } else if (playerHand.getHandValue()<=21 && playerHand.getHandValue()>= houseHand.getHandValue()) {
            System.out.println("User wins");
        } else{
            System.out.println("The house wins");
        }

        System.out.println();

        playerHand.show();

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

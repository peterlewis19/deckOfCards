import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> currrentHand;
    private String name;

    public Hand(String name){
        this.name = name;
        currrentHand = new ArrayList<>();
    }

    public void add(Card c) {
        currrentHand.add(c);
    }

    public Card get(int index){
        return currrentHand.get(index);
    }

    public int size(){
        return currrentHand.size();
    }

    //shows the cards of the hand (DONT DO FOR DEALER)
    public void show() {
        System.out.println(name + ":");

        for (int i=0; i<currrentHand.size(); i++) {
            Card c = currrentHand.get(i);
            System.out.println(c);
        }
    }

    //returns the value of the hand
    public int getHandValue(){
        int handValue = 0;
        int aceCount = 0;

        //adds each cards value to find the hand value
        for (Card card : currrentHand) {
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

}

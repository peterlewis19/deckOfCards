public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit){
        this.value = value;
        this.suit = suit;
    }

    public String toString(){
        return getValue() + " of " + getSuit();
    }

    public String getSuit(){
        return suit;
    }

    public int getNumberValue(){
        return value;
    }

    public String getValue(){
        if (value == 1){
            return "Ace";
        } else if (value == 11){
            return "Jack";
        } else if (value == 12){
            return "Queen";
        } else if (value == 13){
            return "King";
        } else{
            return String.valueOf(value);
        }
    }

    public int myCompareTo(Card nextCard){
        //currentCard.myCompareTo(nextCard);
        //ace>king>queen>jack>1098765432
        //when same value, spades > clubs > diamonds > heart
        String value = getValue();
        int intValue;
        String suit = getSuit();
        int suitValue;

        String nextValue = nextCard.getValue();
        int intNextValue;
        String nextSuit = nextCard.getSuit();
        int nextSuitValue;

        if (value.equals("Ace")){
            intValue = 14;
        } else if (value.equals("King")){
            intValue = 13;
        } else if (value.equals("Queen")){
            intValue = 12;
        } else if (value.equals("Jack")){
            intValue = 11;
        } else{
            intValue = Integer.parseInt(value);
        }

        if (nextValue.equals("Ace")){
            intNextValue = 14;
        } else if (nextValue.equals("King")){
            intNextValue = 13;
        } else if (nextValue.equals("Queen")){
            intNextValue = 12;
        } else if (nextValue.equals("Jack")){
            intNextValue = 11;
        } else{
            intNextValue = Integer.parseInt(nextValue);
        }

        if (intValue>intNextValue){
            return -1;
        } else if (intNextValue>intValue){
            return 1;
        } else{
            // spades > clubs > diamonds > hearts
            if (suit.equals("Spades")){
                suitValue = 3;
            } else if (suit.equals("Clubs")){
                suitValue = 2;
            } else if (suit.equals("Diamonds")){
                suitValue = 1;
            } else {
                suitValue= 0;
            }

            if (nextSuit.equals("Spades")){
                nextSuitValue = 3;
            } else if (nextSuit.equals("Clubs")){
                nextSuitValue = 2;
            } else if (nextSuit.equals("Diamonds")){
                nextSuitValue = 1;
            } else {
                nextSuitValue= 0;
            }

            if (suitValue > nextSuitValue){
                return -1;
            } else if (suitValue < nextSuitValue){
                return 1;
            } else {
                return 0;
            }
        }


    }
}

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

    public int compareTo(Card nextCard){
        //currentCard.compareTo(nextCard);
        //ace>king>queen>jack>1098765432
        //when same value, spades > clubs > diamonds > heart
        String value = getValue();
        int intValue;

        String nextValue = nextCard.getValue();
        int intNextValue;

        if (value.equals("Ace")){
            intValue = 14;
        } else if (value.equals("King")){
            intValue = 13;
        } else if (value.equals("Queen")){
            intValue = 12;
        } else if (value.equals("Jack")){
            intValue = 11;
        }


    }
}

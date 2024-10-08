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
}

public class Deck {
    private Card[] deckOfCards;
    private String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};

    public Deck(){
        this.deckOfCards = new Card[52];
    }

    //displays every card
    public void displayDeck(){
        for (Card currentCard: deckOfCards){
            System.out.println(currentCard);
        }
    }

    //adds every card to the deck
    public void addsToDeck(){
        int cardCount = 0;

        for (String suit: suits){
            for (int i=1; i < 14; i++){
                Card newCard = new Card(i, suit);
                deckOfCards[cardCount] = newCard;

                cardCount++;
            }
        }
    }

    public void bubbleSort(){

    }
}

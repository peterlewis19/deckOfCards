public class Deck {
    private Card[] deckOfCards;
    private final String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};

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
        boolean sorted = true;

        while (sorted){
            sorted = false;

            for (int i=0; i<deckOfCards.length-1; i++){
                int comparison = deckOfCards[i].toString().compareTo(deckOfCards[i+1].toString());

                deckOfCards[i].compareTo(deckOfCards[i+1]);

                //..count > ..count+1
                if (comparison > 0){
                    sorted = true;
                    //swaps the 2 cards
                    Card temp = deckOfCards[i];
                    deckOfCards[i] = deckOfCards[i+1];
                    deckOfCards[i+1] = temp;
                }

            }
        }
    }

}

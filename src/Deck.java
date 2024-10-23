import java.util.Random;

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
    //Fisher Yates shuffle
    public void betterShuffle(){
        int randomIndex;
        Random r = new Random();

        for (int i = 51; i>0; i--) {
            randomIndex = r.nextInt(i+1);

            Card temp = deckOfCards[randomIndex];
            deckOfCards[randomIndex] = deckOfCards[i];
            deckOfCards[i] = temp;
        }
    }

    //gives the length
    public int length(){
        int cardCount = 0;
        for (Card card: deckOfCards){
            cardCount++;
        }

        return cardCount;
    }

    public Card dealCardN(int index){
        return deckOfCards[index];
    }

}

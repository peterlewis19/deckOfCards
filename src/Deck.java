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

    public void bubbleSort(){
        boolean swapped = true;
        int passNumber = 0;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < deckOfCards.length - 1 - passNumber; i++) {
                int  comparison = deckOfCards[i].myCompareTo(deckOfCards[i+1]);

                if (comparison > 0) {
                    //swaps i+1 and i
                    Card temp;
                    temp = deckOfCards[i + 1];
                    deckOfCards[i + 1] = deckOfCards[i];
                    deckOfCards[i] = temp;

                    swapped = true;
                }
            }
            passNumber++;
        }
    }

    public void shuffle(){
        int randomIndex = (int)(Math.random()*deckOfCards.length);

        for (int i = 0; i< deckOfCards.length; i++) {
            Card temp = deckOfCards[randomIndex];
            deckOfCards[randomIndex] = deckOfCards[i];
            deckOfCards[i] = temp;

            randomIndex = (int)(Math.random()*deckOfCards.length);
        }
    }
    //Fisher Yates shuffle
    public void betterShuffle(){
        int randomIndex;
        Random r = new Random();

        for (int i = 51; i>0; i--) {
            randomIndex = r.nextInt(0, i+1);

            Card temp = deckOfCards[randomIndex];
            deckOfCards[randomIndex] = deckOfCards[i];
            deckOfCards[i] = temp;
        }
    }
    //Create a deal method that takes two integer parameters: hand and players.
    // It then deals the number of cards specified in hand, to each of the players. e.g 7 cards to 2 players
    // The cards should be dealt from one end of the array and should be dealt
    // in turn to each of the players. Each hand should be printed out separately.
    public void deal(int hand, int players){
        Card[] hands = new Card[players];

        for (int i = 1; i <= players; i++){//counts players
            System.out.println("PLAYER " + i + " GETS: ");
            for (int j = 1; j<hand; j++){ //counts cards in hands 0, 5, 10, 15| 1, 6, 11, 16 | 2, 7, 12, 17| 3,8,13,18
                System.out.print(deckOfCards[((j*5)-5)+i] + ", ");
            }
            System.out.println(deckOfCards[((hand*5)-5)+i]);
            System.out.println();

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

package models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        this.newDeck();
        this.shuffleDeck();
    }

    private void newDeck() {
        for (CardType type : CardType.values()) {

            for (int i = 1; i <= 13; i++) {

                deck.add(new Card(i, type));
            }
        }
    }

    public ArrayList<Card> showDeck() {
        return deck;
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }
    
    public Card drawCard(){
        Card tempCard = deck.getFirst();
        deck.removeFirst();
        
        return tempCard;
    }

}

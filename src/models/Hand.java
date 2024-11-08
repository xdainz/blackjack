package models;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
        
    }

    public void draw(Deck deck) {
        if (deck != null && !deck.showDeck().isEmpty()) {

            hand.add(deck.drawCard());
        }
    }

    private ArrayList total() {

        ArrayList holder = new ArrayList<>();
        if (!hand.isEmpty()) {
            int total1 = 0;
            int total2 = 0;

            for (Card card : hand) {
                if (card.getValue() == 1) {
                    total1 += 1;
                    total2 += 11;
                } else {
                    total1 += card.getValue();
                    total2 += card.getValue();
                }
            }

            if (total1 == total2) {
                holder.add(total1);
                return holder;
            } else {
                holder.add(total1);
                holder.add(total2);
                return holder;
            }

        } else {
            holder.add(0);
            return holder;
        }
    }

    public ArrayList<Card> showHand() {
        return hand;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hand{");
        sb.append(hand).append(" = ").append(this.total());
        return sb.toString();
    }

}

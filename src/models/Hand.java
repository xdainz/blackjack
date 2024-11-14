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

    public ArrayList total() {

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

    public ArrayList<Card> getHand() {
        return hand;
    }

    public boolean hasBlackjack() {
        if (this.getHand().size() == 2) {
            // checkiamos si el dealer tiene blackjack
            return (this.getHand().getFirst().getValue() == 1 && this.getHand().getLast().getValue() == 10) || (this.getHand().getFirst().getValue() == 1 && this.getHand().getLast().getValue() == 10);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hand{");
        sb.append(hand).append(" = ").append(this.total());
        return sb.toString();
    }

}

package models;

import java.util.ArrayList;

public class Game {

    Deck deck;
    Hand player;
    Hand dealer;

    public Game() {
        deck = new Deck();
        player = new Hand();
        dealer = new Hand();

        player.draw(deck);
        dealer.draw(deck);

    }

    public void playerDraw() {
        player.draw(deck);
    }

    public void dealerDraw() {
        dealer.draw(deck);
    }

    public String showPlayerHand() {
        StringBuilder sb = new StringBuilder();

        for (Card card : player.getHand()) {
            sb.append(card.getValue()).append(card.getIcon()).append("\n");
        }

        return sb.toString();
    }

    public String showDealerHand() {
        StringBuilder sb = new StringBuilder();

        for (Card card : dealer.getHand()) {
            sb.append(card.getValue()).append(card.getIcon()).append("\n");
        }

        return sb.toString();
    }

    public ArrayList getPlayerTotal() {
        return player.total();
    }

    public ArrayList getDealerTotal() {
        return dealer.total();
    }

    public String dealerStart() {
        return "[Hidden Card]\n"+dealer.getHand().getLast().showCard();

    }

}

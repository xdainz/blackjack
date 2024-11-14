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
            sb.append(card.getFigure()).append(card.getIcon()).append("\n");
        }

        return sb.toString();
    }

    public String showDealerHand() {
        StringBuilder sb = new StringBuilder();

        for (Card card : dealer.getHand()) {
            sb.append(card.getFigure()).append(card.getIcon()).append("\n");
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
        return "[Hidden Card]\n" + dealer.getHand().getLast().showCard();

    }

    public boolean playerBusted() {
        return (int) player.total().getFirst() > 21;
    }

    public boolean dealerBusted() {
        return (int) dealer.total().getFirst() > 21;
    }

    public boolean getBigger(Hand h1, Hand h2) {
        return (((int) h1.total().getFirst() > (int) h2.total().getFirst()
                || (int) h1.total().getLast() > (int) h2.total().getFirst())
                || ((int) h1.total().getFirst() > (int) h2.total().getLast()
                || (int) h1.total().getLast() > (int) h2.total().getLast()));
    }

    public String getWinner() {
        if (dealer.hasBlackjack() || player.hasBlackjack()) {
            // check if anyone has blackjack

            if (dealer.hasBlackjack() && player.hasBlackjack()) {
                // check if BOTH have blackjack
                return "Double Blackjack!\n It's a Draw!";

            } else if (player.hasBlackjack()) {
                // player wins
                return "Blackjack!\nYou win!";
            } else {
                // dealer wins
                return "Blackjack!\nDealer wins!";
            }

        } else if (this.playerBusted() || this.dealerBusted()) {
            // check if anyone busted

            if (this.playerBusted()) {
                return "You busted\nDealer wins!";
            } else {
                return "Dealer busted\nYou win!";
            }

        } else {
            // no blackjacks
            if ((int) player.total().getFirst() == 21 || (int) player.total().getLast() == 21) {
                // check player == 21
                if ((int) dealer.total().getFirst() == 21 || (int) dealer.total().getLast() == 21) {
                    // draw
                    return "Both at 21!\nIt's a Draw!";
                }

            } else if (this.getBigger(player, dealer)) {
                return "Player wins!";

            } else if (player.total().getFirst() == dealer.total().getFirst()
                    || player.total().getFirst() == dealer.total().getLast()
                    || player.total().getLast() == dealer.total().getFirst()
                    || player.total().getLast() == dealer.total().getLast()) {
                return "Draw!";
            }
            return "Dealer wins!";

        }

    }
}

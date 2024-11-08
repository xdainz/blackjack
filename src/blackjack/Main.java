package blackjack;

import models.*;

public class Main {

    public static void main(String[] args) {
        Deck d = new Deck();
        Hand player = new Hand();
        
        //System.out.println(d.showDeck());
        
        System.out.println(player);
        
        player.draw(d);
        System.out.println(player);
        player.draw(d);
        System.out.println(player);
        
    }

}

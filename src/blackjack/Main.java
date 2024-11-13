package blackjack;

import models.*;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        
        game.playerDraw();
        System.out.println(game.showPlayerHand());
    }

}

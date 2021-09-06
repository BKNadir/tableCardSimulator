package com.bknadir.assets;

import java.util.Collections;

public class GameBlackJack extends Game{
    public GameBlackJack() {
        super(false, 3, 1);
        createPlayers();
        Collections.reverse(players);
    }

    public void initiate() throws Exception {
        deck = new Deck(false, 1);
        deck.randomize();
        for (Player p : players) {
            p.getHand().addCard(deck.removeCard(0));
            p.getHand().addCard(deck.removeCard(0));
        }
    }

    public void run() throws Exception {
        boolean run = true;
        String res = "";
        do{
            initiate();
            for (Player p : players) {
                if (!p.getUsername().contains("IA")) {
                    System.out.println("Le croupier montre sa carte " + players.get(players.size()-1).getHand().getDeck().get(0));
                    do{
                        System.out.println("Voici votre main :");
                        System.out.println(p.getHand().getDeck());
                        if (isBlackjack(p.getHand(), true) == 21 || isBlackjack(p.getHand(), false) == 21){
                            System.out.println("Tu as un BlackJack. Gagné !");
                            res = "";
                        }else {
                            System.out.println("Voullez vous piocher une carte ?");
                            res = sc.next();
                        }
                        if ((res == "o") || (res == "O") || (res == "oui") || (res == "Oui") || (res == "OUI") ){
                            p.getHand().addCard(deck.removeCard(0));
                        }
                    } while ((res == "o") || (res == "O") || (res == "oui") || (res == "Oui") || (res == "OUI"));


                }else {
                    if (isBlackjack(p.getHand(), true) == 21 || isBlackjack(p.getHand(), false) == 21){
                        System.out.println("Le croupier à un BlackJack !");
                    } else if (isBlackjack(p.getHand(), true) < 17 || isBlackjack(p.getHand(), false) < 17){
                        p.getHand().addCard(deck.removeCard(0));
                    }
                }
                System.out.println("Continuer ?");
                res = sc.next();
                run = ((res == "o") || (res == "O") || (res == "oui") || (res == "Oui") || (res == "OUI"));
            }
        } while (run);
    }

    public int isBlackjack(Deck deck, boolean as){
        int value = 0;
        for (Card c : deck.getDeck() ) {
            if (as && c.getValue() == 1) value += 9;
            value += c.getValue();
        }
        return value;
    }
}
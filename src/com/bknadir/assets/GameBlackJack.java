package com.bknadir.assets;

import java.util.Collections;

public class GameBlackJack extends Game{
    public GameBlackJack() {
        super(false, 1, 1);
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
                    System.out.println("Le croupier montre sa carte " + players.get(players.size()).getHand().getDeck().get(0));
                    do{
                        System.out.println("Voici votre main :");
                        System.out.println(p.getHand().getDeck());
                        if (isBlackjack(deck, true) == 21 || isBlackjack(deck, false) == 21){
                            System.out.println("Tu as un BlackJack. Gagné !");
                            res = "";
                        }else {
                            System.out.println("Voullez vous piocher une carte ?");
                            res = sc.nextLine();
                        }
                    } while ((res == "o") || (res == "O") || (res == "oui") || (res == "Oui") || (res == "OUI"));


                }else {
                    if (isBlackjack(deck, true) == 21 || isBlackjack(deck, false) == 21){

                    } else if (isBlackjack(deck, true) < 17 || isBlackjack(deck, false) < 17){

                    }
                }
                System.out.println("Continuer ?");
                res = sc.nextLine();
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
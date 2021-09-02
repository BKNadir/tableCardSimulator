package com.bknadir.assets;

import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(boolean joker, int nbDeck, int nbIA){
        this.deck = new Deck(joker, nbDeck);
        this.players = new ArrayList<Player>();
        for (int i = 0; i < nbIA; i++){
            players.add(new PlayerIA("IA "+(i+1), this));
        }
    }

    public void run(){

    }

}

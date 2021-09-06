package com.bknadir.assets;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    protected Deck deck;
    protected ArrayList<Player> players;
    protected Scanner sc = new Scanner(System.in);

    public Game(boolean joker, int nbDeck, int nbIA){
        this.deck = new Deck(joker, nbDeck);
        this.players = new ArrayList<Player>();
        for (int i = 0; i < nbIA; i++){
            players.add(new PlayerIA("IA "+(i+1), this));
        }
    }

    public void createPlayers(){
        Player p;
        String username;
        System.out.println("Combien de joueurs ?");
        int nbPlayer = sc.nextInt();
        for (int i = 0; i < nbPlayer; i++){

            do {
                System.out.println("Entrez le pseudo du " + (i+1) + " joueur :");
                username = sc.next();
                p = new Player(username);
                if (players.contains(p)){
                    System.out.println("Ce pseudo est déjà utilisé. Choisisez en un autre.");
                }
            } while (players.contains(p));
            players.add(p);
        }
    }

    public void initiate() throws Exception {

    }

    public void run() throws Exception {

    }
}

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
        String name;
        System.out.println("Combien de joueurs ?");
        int nbPlayer = sc.nextInt();
        for (int i = 0; i < nbPlayer; i++){
            System.out.println("Entrez le pseudo du " + (i+1) + " joueur :");
            do {
                name = sc.nextLine();
                p = new Player(name);
                if (players.contains(p)){
                    System.out.println("Ce pseudo est déjà utilisé. Choisisez en un autre.");
                }
            } while (!players.contains(p));
            players.add(p);
        }
    }

    public void initiate() throws Exception {

    }

    public void run() throws Exception {

    }
}

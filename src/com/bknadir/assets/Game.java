package com.bknadir.assets;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;
    private Scanner sc = new Scanner(System.in);

    public Game(boolean joker, int nbDeck, int nbIA){
        this.deck = new Deck(joker, nbDeck);
        this.players = new ArrayList<Player>();
        for (int i = 0; i < nbIA; i++){
            players.add(new PlayerIA("IA "+(i+1), this));
        }
    }

    public void run(){

    }

    private void initiate(){
        Player p;
        System.out.println("Combien de joueurs ?");
        int nbPlayer = sc.nextInt();
        for (int i = 0; i < nbPlayer; i++){
            System.out.println("Entrez le pseudo du " + (i+1) + " joueur :");
            do {
                p = new Player(sc.nextLine());
                if (players.contains(p)){

                }
            } while (!players.contains(p));
            players.add(p);
        }
    }

}

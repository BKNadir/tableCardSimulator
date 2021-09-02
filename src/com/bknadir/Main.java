package com.bknadir;

import com.bknadir.assets.*;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        Deck deck = new Deck(true);
        System.out.println(deck);
        deck.randomize();
        System.out.println(deck);
        deck.sort();
        System.out.println(deck);
    }
}

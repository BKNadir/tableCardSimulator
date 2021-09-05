package com.bknadir.assets;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(boolean joker, int nbDeck){
        this.deck = new ArrayList<Card>();
        if (joker) {
            deck.add(new Card());
            deck.add(new Card());
        }
        for (int i = 0; i < nbDeck; i++){
            for (int color = 0; color < 4; color++){
                for (int value = 1; value < 14; value++){
                    deck.add(new Card(value, color));
                }
            }
        }
    }

    public Deck(boolean joker){
        this(joker, 1);
    }
    
    public Deck(int nbDeck){
        this(false, nbDeck);
    }
    
    public Deck(){
        this(false, 1);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public boolean addCard(Card card){
        try{
            deck.add(card);
        }
        catch(ArithmeticException e){
            return false;
        }
        return true;
    }

    private Card findCard(Card card){
        for (Card c : deck) {
            if (c.getValue() == card.getValue() && c.getColor() == card.getColor()) return c;
        }
        return null;
    }

    public boolean deleteCard(Card card) throws Exception {
        Card c = findCard(card);
        try{
            if (c.equals(null)) throw new Exception("Card not found");
            deck.remove(c);
        }
        catch(Exception e){
            return false;
        }
        return !c.equals(null);
    }

    public Card removeCard(int nb) throws Exception {
        Card c;
        try{
            if (nb > deck.size()) throw new Exception("Card not found");
            c = deck.get(0);
        }
        catch(Exception e){
            return null;
        }
        return c;
    }

    public Card removeCard(Card card) throws Exception {
        Card c = findCard(card);
        try{
            if (c.equals(null)) throw new Exception("Card not found");
            deck.remove(c);
        }
        catch(Exception e){
            return null;
        }
        return c;
    }

    public void randomize(){
        Collections.shuffle(deck);
    }

    public void sort(){
        Collections.sort(deck);
    }

    @Override
    public String toString() {
        String s = "";
        for (Card card: deck) {
            s+= card + "\n";
        }
        return s;
    }
}

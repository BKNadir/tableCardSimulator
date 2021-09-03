package com.bknadir.assets;

public class Player {
    private String username;
    private Deck hand;
    private int score;

    public Player(String username) {
        this.username = username;
        this.hand = new Deck(false, 0);
        this.score = 0;
    }

    public String getUsername() {
        return username;
    }

    public Deck getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (o.equals(null)) throw new NullPointerException("Player is null");
        return this.username == ((Player)(o)).getUsername();
    }
}

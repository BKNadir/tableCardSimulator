package com.bknadir.assets;

public class PlayerIA extends Player{
    private Game currentGame;
    
    public PlayerIA(String username, Game game) {
        super(username);
        this.currentGame = game;
    }
}

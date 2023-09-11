package com.example.androidstudio2dgamedev.gamestates;

import com.example.androidstudio2dgamedev.main.Game;

public abstract class BaseState {
    protected Game game;

    public BaseState(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}

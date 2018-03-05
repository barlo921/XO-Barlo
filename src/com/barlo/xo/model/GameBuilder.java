package com.barlo.xo.model;

public class GameBuilder {
    private String player1;
    private String player2;
    private int fieldSize;

    public GameBuilder setPlayer1(String player1) {
        this.player1 = player1;
        return this;
    }

    public GameBuilder setPlayer2(String player2) {
        this.player2 = player2;
        return this;
    }

    public GameBuilder setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
        return this;
    }

    public Game createGame() {
        return new Game(player1, player2, fieldSize);
    }
}
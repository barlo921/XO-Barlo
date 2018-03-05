package com.barlo.xo.model;

public class GameBuilder {
    private Player player1;
    private Player player2;
    private int fieldSize;

    public GameBuilder setPlayer1(Player player1) {
        this.player1 = player1;
        return this;
    }

    public GameBuilder setPlayer2(Player player2) {
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
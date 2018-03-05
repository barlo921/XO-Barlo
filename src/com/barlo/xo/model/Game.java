package com.barlo.xo.model;


public class Game {

    private final String player1;
    private final String player2;

    private final Field field;

    Game(String player1, String player2, final int fieldSize) {
        this.player1 = player1;
        this.player2 = player2;

        field = new Field(fieldSize);
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public Field getField() {
        return field;
    }
}

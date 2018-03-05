package com.barlo.xo.model;


public class Game {

    private final Player player1;
    private final Player player2;

    private final Field field;

    Game(Player player1, Player player2, final int fieldSize) {
        this.player1 = player1;
        this.player2 = player2;

        field = new Field(fieldSize);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Field getField() {
        return field;
    }
}

package com.barlo.xo.model;


import com.barlo.xo.model.exceptions.TwoPlayersSameFigureException;

public class Game {

    private final Player player1;
    private final Player player2;

    private final Field field;

    Game(Player player1, Player player2, final int fieldSize) throws TwoPlayersSameFigureException {

        if (checkSameFigure(player1, player2, Figure.X) | checkSameFigure(player1, player2, Figure.O)) {
            throw new TwoPlayersSameFigureException();
        }

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

    private boolean checkSameFigure(Player player1, Player player2, Figure figure) {

        return player1.getPlayersFigure() == figure && player2.getPlayersFigure() == figure;

    }
}

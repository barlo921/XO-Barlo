package com.barlo.xo.model;


import com.barlo.xo.model.exceptions.TwoPlayersSameFigureException;

public class Game {

    private final Player player1;
    private final Player player2;

    private final Field field;

    Game(final GameBuilder gameBuilder) throws TwoPlayersSameFigureException {

        if (checkSameFigure(gameBuilder.getPlayer1(), gameBuilder.getPlayer2(), Figure.X) | checkSameFigure(gameBuilder.getPlayer1(), gameBuilder.getPlayer2(), Figure.O)) {
            throw new TwoPlayersSameFigureException();
        }

        player1 = gameBuilder.getPlayer1();
        player2 = gameBuilder.getPlayer2();

        field = new Field(gameBuilder.getFieldSize());

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

    public static class GameBuilder {
        private Player player1;
        private Player player2;
        private int fieldSize;

        public GameBuilder player1(Player player1) {
            this.player1 = player1;
            return this;
        }

        public GameBuilder player2(Player player2) {
            this.player2 = player2;
            return this;
        }

        public GameBuilder fieldSize(int fieldSize) {
            this.fieldSize = fieldSize;
            return this;
        }

        public Game createGame() throws TwoPlayersSameFigureException {
            return new Game(this);
        }

        public Player getPlayer1() {
            return player1;
        }

        public Player getPlayer2() {
            return player2;
        }

        public int getFieldSize() {
            return fieldSize;
        }
    }
}

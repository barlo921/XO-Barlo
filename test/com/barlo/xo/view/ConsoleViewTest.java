package com.barlo.xo.view;

import com.barlo.xo.model.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class ConsoleViewTest {

    @Test
    public void printFieldWithNoFigures() throws Exception {

        Game gameXO = new Game.GameBuilder()
                .player1(new Player("Player 1", Figure.X))
                .player2(new Player("Player 2", Figure.O))
                .fieldSize(3)
                .createGame();


        ConsoleView consoleView = new ConsoleView(gameXO);

        consoleView.printField();

    }

    @Test
    public void printFieldWithFigures() throws Exception {

        Game gameXO = new Game.GameBuilder()
                .player1(new Player("Player 1", Figure.X))
                .player2(new Player("Player 2", Figure.O))
                .fieldSize(3)
                .createGame();

        Field field = gameXO.getField();

        for (int i=0; i<field.getFieldSize(); i++) {
            field.setFigure(new Point(i,i), Figure.X);
        }

        ConsoleView consoleView = new ConsoleView(gameXO);

        consoleView.printField();

    }

}
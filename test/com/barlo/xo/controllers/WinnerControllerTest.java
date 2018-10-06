package com.barlo.xo.controllers;


import com.barlo.xo.model.*;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;
import com.barlo.xo.model.exceptions.TwoPlayersSameFigureException;
import com.barlo.xo.view.ConsoleView;
import org.junit.Test;

import static org.junit.Assert.*;


public class WinnerControllerTest {

    @Test
    public void figureXFirstLineWinner() throws InvalidCoordinateException {

    Figure winner = Figure.X;

    Field field = new Field(3);

        for (int i=0; i<field.getFieldSize(); i++) {
        field.setFigure(new Point(0,i), Figure.X);
    }

    assertEquals(winner, new WinnerController().getWinner(field));

}

    @Test
    public void figureXFirstLineTwoFigures() throws InvalidCoordinateException {

        Figure winner = Figure.X;

        Field field = new Field(3);

        for (int i=0; i<field.getFieldSize()-1; i++) {
            field.setFigure(new Point(0,i), Figure.X);
        }

        assertNull(new WinnerController().getWinner(field));

    }


    @Test
    public void figureXSecondLineWinner() throws InvalidCoordinateException, TwoPlayersSameFigureException {

        Figure winner = Figure.X;

        Game gameXO = new Game.GameBuilder()
                .player1(new Player("Player 1", Figure.X))
                .player2(new Player("Player 2", Figure.O))
                .fieldSize(3)
                .createGame();

        ConsoleView consoleView = new ConsoleView(gameXO);
        Field field = gameXO.getField();

        for (int i=0; i<field.getFieldSize(); i++) {
            field.setFigure(new Point(1,i), Figure.X);
        }


        assertEquals(winner, new WinnerController().getWinner(field));

    }

    @Test
    public void figureXThirdLineWinner() throws InvalidCoordinateException {

        Figure winner = Figure.X;

        Field field = new Field(3);

        for (int i=0; i<field.getFieldSize(); i++) {
            field.setFigure(new Point(2,i), Figure.X);
        }

        assertEquals(winner, new WinnerController().getWinner(field));

    }


    @Test
    public void figureXIsNotFirstLineWinner() throws InvalidCoordinateException {

        Figure winner = Figure.X;

        Field field = new Field(3);

        for (int i=0; i<field.getFieldSize(); i++) {
            field.setFigure(new Point(0,i), Figure.O);
        }

        assertNotEquals(winner, new WinnerController().getWinner(field));

    }

    @Test
    public void figureXFirstRowWinner() throws InvalidCoordinateException {

        Figure winner = Figure.X;

        Field field = new Field(3);

        for (int i=0; i<field.getFieldSize(); i++) {
            field.setFigure(new Point(i,0), Figure.X);
        }

        assertEquals(winner, new WinnerController().getWinner(field));

    }

    @Test
    public void figureXSecondRowWinner() throws InvalidCoordinateException {

        Figure winner = Figure.X;

        Field field = new Field(3);

        for (int i=0; i<field.getFieldSize(); i++) {
            field.setFigure(new Point(i,1), Figure.X);
        }

        assertEquals(winner, new WinnerController().getWinner(field));

    }


    @Test
    public void figureXThirdRowWinner() throws InvalidCoordinateException {

        Figure winner = Figure.X;

        Field field = new Field(3);

        for (int i=0; i<field.getFieldSize(); i++) {
            field.setFigure(new Point(i,2), Figure.X);
        }

        assertEquals(winner, new WinnerController().getWinner(field));

    }


    @Test
    public void figureXStraightDiagonalWinner() throws InvalidCoordinateException {

        Figure winner = Figure.X;

        Field field = new Field(3);

        for (int i=0; i<field.getFieldSize(); i++) {
            field.setFigure(new Point(i,i), Figure.X);
        }

        assertEquals(winner, new WinnerController().getWinner(field));

    }


    @Test
    public void figureXReverseDiagonalWinner() throws InvalidCoordinateException {

        Figure winner = Figure.X;

        Field field = new Field(3);

        for (int i=0; i<field.getFieldSize(); i++) {
            field.setFigure(new Point(2-i,i), Figure.X);
        }

        assertEquals(winner, new WinnerController().getWinner(field));

    }

    @Test
    public void checkDraw() throws InvalidCoordinateException {

        Field field = new Field(3);

        assertNull(new WinnerController().getWinner(field));

    }

}

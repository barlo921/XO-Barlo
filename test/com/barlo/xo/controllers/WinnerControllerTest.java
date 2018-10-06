package com.barlo.xo.controllers;


import com.barlo.xo.model.Field;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Point;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;
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
    public void figureXSecondLineWinner() throws InvalidCoordinateException {

        Figure winner = Figure.X;

        Field field = new Field(3);

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

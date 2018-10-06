package com.barlo.xo.controllers;

import com.barlo.xo.model.Field;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Point;
import org.junit.Test;

import static org.junit.Assert.*;


public class CurrentMoveControllerTest {

    @Test
    public void currentMoveXTurnWhenNoFigureSetOnField() throws Exception {

        Field field = new Field(3);

        CurrentMoveController currentMoveController = new CurrentMoveController();
        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }


    @Test
    public void currentMoveWhenFieldIsFullByX() throws Exception {

        Field field = new Field(3);

        for (int x=0; x<field.getFieldSize(); x++) {
            for (int y=0; y<field.getFieldSize(); y++) {
                field.setFigure(new Point(x, y), Figure.X);
            }
        }

        CurrentMoveController currentMoveController = new CurrentMoveController();
        assertNull(currentMoveController.currentMove(field));
    }

    @Test
    public void currentMoveWhenFieldIsFullByO() throws Exception {

        Field field = new Field(3);

        for (int x=0; x<field.getFieldSize(); x++) {
            for (int y=0; y<field.getFieldSize(); y++) {
                field.setFigure(new Point(x, y), Figure.O);
            }
        }

        CurrentMoveController currentMoveController = new CurrentMoveController();
        assertNull(currentMoveController.currentMove(field));
    }

    @Test
    public void currentMoveForX() throws Exception {

        Field field = new Field(3);

        for (int x=0; x<field.getFieldSize(); x++) {
            for (int y=0; y<2; y++) {
                field.setFigure(new Point(x, y), Figure.X);
            }
        }

        CurrentMoveController currentMoveController = new CurrentMoveController();
        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }

    @Test
    public void currentMoveForO() throws Exception {

        Field field = new Field(3);

        for (int x=0; x<field.getFieldSize(); x++) {
            for (int y=0; y<1; y++) {
                field.setFigure(new Point(x, y), Figure.O);
            }
        }

        CurrentMoveController currentMoveController = new CurrentMoveController();
        assertEquals(Figure.O, currentMoveController.currentMove(field));
    }

}
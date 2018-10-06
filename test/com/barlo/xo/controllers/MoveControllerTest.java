package com.barlo.xo.controllers;

import com.barlo.xo.model.Field;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Point;
import com.barlo.xo.model.exceptions.AlreadyOccupiedException;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;
import org.junit.Test;

import static org.junit.Assert.*;


public class MoveControllerTest {

    @Test
    public void testMoveWithSameFigure() throws InvalidCoordinateException {
        Field field = new Field(3);
        field.setFigure(new Point(0,0), Figure.X);

        MoveController mv = new MoveController();

        Point sameCoordinatePoint = new Point(0,0);

        try {
            mv.applyFigure(field, sameCoordinatePoint, Figure.X);
            fail();
        } catch (AlreadyOccupiedException e) {

        }
    }

    @Test
    public void testMoveWithDifferentFigures() throws InvalidCoordinateException {
        Field field = new Field(3);
        field.setFigure(new Point(0,0), Figure.X);

        MoveController mv = new MoveController();

        Point sameCoordinatePoint = new Point(0,0);

        try {
            mv.applyFigure(field, sameCoordinatePoint, Figure.O);
            fail();
        } catch (AlreadyOccupiedException e) {

        }
    }

    @Test
    public void testMoveWithIvalidCoordinate() throws InvalidCoordinateException, AlreadyOccupiedException {
        Field field = new Field(3);
        field.setFigure(new Point(0,0), Figure.X);

        MoveController mv = new MoveController();

        Point sameCoordinatePoint = new Point(5,5);

        try {
            mv.applyFigure(field, sameCoordinatePoint, Figure.O);
            fail();
        } catch (InvalidCoordinateException e) {

        }
    }

}

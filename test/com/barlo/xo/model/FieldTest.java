package com.barlo.xo.model;

import com.barlo.xo.model.exceptions.InvalidCoordinateException;
import org.junit.Test;

import static org.junit.Assert.*;


public class FieldTest {

    @Test
    public void testFieldSize() throws Exception {

        final int actualFieldSize = 3;

        Field field = new Field(actualFieldSize);
        assertEquals(actualFieldSize, field.getFieldSize());

    }

    @Test
    public void testSetFigure() throws Exception {

        final int actualFieldSize = 3;

        final Field field = new Field(actualFieldSize);

        final Figure actualFigure = Figure.X;

        field.setFigure(new Point(0,0), actualFigure);

        assertEquals(actualFigure, field.getFigure(new Point(0,0)));

    }

    @Test
    public void testFetFigureWhenFigureIsNotSet() throws Exception {

        final int actualFieldSize = 3;

        final Field field = new Field(actualFieldSize);

        final Point point = new Point(0,0);

        assertNull(field.getFigure(point));

    }


    @Test
    public void testSetFigureWhenXIsLessThenZero() throws Exception {

        final int actualFieldSize = 3;

        final Field field = new Field(actualFieldSize);

        final Figure actualFigure = Figure.X;

        final Point pointWithXLessThenZero = new Point(-1, 0);

        try {
            field.setFigure(pointWithXLessThenZero, actualFigure);
            fail();
        } catch (InvalidCoordinateException e) {

        }

    }


    @Test
    public void testSetFigureWhenYIsLessThenZero() throws Exception {

        final int actualFieldSize = 3;

        final Field field = new Field(actualFieldSize);

        final Figure actualFigure = Figure.X;

        final Point pointWithXLessThenZero = new Point(0, -1);

        try {
            field.setFigure(pointWithXLessThenZero, actualFigure);
            fail();
        } catch (InvalidCoordinateException e) {

        }

    }


    @Test
    public void testSetFigureWhenXAndYIsLessThenZero() throws Exception {

        final int actualFieldSize = 3;

        final Field field = new Field(actualFieldSize);

        final Figure actualFigure = Figure.X;

        final Point pointWithXLessThenZero = new Point(-1, -1);

        try {
            field.setFigure(pointWithXLessThenZero, actualFigure);
            fail();
        } catch (InvalidCoordinateException e) {

        }

    }


    @Test
    public void testSetFigureWhenXIsMoreThenMaxCoordinate() throws Exception {

        final int actualFieldSize = 3;

        final Field field = new Field(actualFieldSize);

        final Figure actualFigure = Figure.X;

        final Point pointWithXLessThenZero = new Point(99, 0);

        try {
            field.setFigure(pointWithXLessThenZero, actualFigure);
            fail();
        } catch (InvalidCoordinateException e) {

        }

    }


    @Test
    public void testSetFigureWhenYIsMoreThenMaxCoordinate() throws Exception {

        final int actualFieldSize = 3;

        final Field field = new Field(actualFieldSize);

        final Figure actualFigure = Figure.X;

        final Point pointWithXLessThenZero = new Point(0, 99);

        try {
            field.setFigure(pointWithXLessThenZero, actualFigure);
            fail();
        } catch (InvalidCoordinateException e) {

        }

    }


    @Test
    public void testSetFigureWhenXAndYIsMoreThenMaxCoordinate() throws Exception {

        final int actualFieldSize = 3;

        final Field field = new Field(actualFieldSize);

        final Figure actualFigure = Figure.X;

        final Point pointWithXLessThenZero = new Point(99, 99);

        try {
            field.setFigure(pointWithXLessThenZero, actualFigure);
            fail();
        } catch (InvalidCoordinateException e) {

        }

    }


}
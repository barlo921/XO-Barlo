package com.barlo.xo.controllers;


import com.barlo.xo.model.Field;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Point;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;

public class WinnerController {

    private Field field;

    public WinnerController(final Field field) {
        this.field = field;
    }

    public Figure checkWinner() throws InvalidCoordinateException {

        for (int i=0; i<field.getFieldSize(); i++) {
            if (checkLine(new Point(i,0), 0, 1)) {
                return field.getFigure(new Point(i,0));
            }
        }

        for (int i=0; i<field.getFieldSize(); i++) {
            if (checkLine(new Point(0,i), 1, 0)) {
                return field.getFigure(new Point(0,i));
            }
        }

        if (checkLine(new Point(0,0), 1, 1)) {
            return field.getFigure(new Point(0,0));
        }

        if (checkLine(new Point(0,2), 1, -1)) {
            return field.getFigure(new Point(0,2));
        }

        return null;
    }

    private boolean checkLine(final Point currentPoint, final int xRule, final int yRule) {

        Point nextPoint = pointGenerator(currentPoint, xRule, yRule);

        try {

            if (field.getFigure(currentPoint) == field.getFigure(nextPoint)) {
                checkLine(nextPoint, xRule, yRule);
            }

            return false;

        } catch (InvalidCoordinateException e) {
            return true;
        }

    }

    //TODO rebuild for lambda
    private Point pointGenerator(final Point point, final int xRule, final int yRule) {
        return new Point(point.getX()+xRule, point.getY()+yRule);
    }

}

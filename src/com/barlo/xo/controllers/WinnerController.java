package com.barlo.xo.controllers;

//Logic to determine the winner

import com.barlo.xo.model.Field;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Point;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;

public class WinnerController {

    private Field field;

    public Figure getWinner(final Field field) throws InvalidCoordinateException {

        this.field = field;


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

    private boolean checkLine(final Point currentPoint, final int xRule, final int yRule) throws InvalidCoordinateException {

        Point nextPoint = pointGenerator(currentPoint, xRule, yRule);

        if (field.getFigure(currentPoint) == null) {
            return false;
        }

        if (field.getFigure(currentPoint) == field.getFigure(nextPoint) && field.getFigure(currentPoint) == field.getFigure(pointGenerator(nextPoint, xRule, yRule))) {
            return true;
        } else {
            return false;
        }

    }

    //TODO rebuild for lambda
    private Point pointGenerator(final Point point, final int xRule, final int yRule) {
        return new Point(point.getX()+xRule, point.getY()+yRule);
    }

}

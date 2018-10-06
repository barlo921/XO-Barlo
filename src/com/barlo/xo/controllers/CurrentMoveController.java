package com.barlo.xo.controllers;

//Logic to determine Figure to turn

import com.barlo.xo.model.Field;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Point;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidCoordinateException {

        int countFigures = 0;

        for (int x=0; x<field.getFieldSize(); x++) {
            countFigures += checkLine(field, x);
        }

        if (countFigures % 2 == 0) return Figure.X;

        if (countFigures == field.getFieldSize()*field.getFieldSize()) return null;

        return Figure.O;

    }

    private int checkLine(final Field field, int row) throws InvalidCoordinateException {

        int countFigures = 0;

        for (int i=0; i<field.getFieldSize(); i++) {
            if (field.getFigure(new Point(row, i)) != null) {
                countFigures++;
            }
        }

        return countFigures;

    }

}

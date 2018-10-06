package com.barlo.xo.controllers;

//Logic for setting Figure at Field during Player's turn

import com.barlo.xo.model.Field;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Point;
import com.barlo.xo.model.exceptions.AlreadyOccupiedException;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;

public class MoveController {


    public void applyFigure(final Field field, final Point point, final Figure figure) throws InvalidCoordinateException, AlreadyOccupiedException {

        if (checkIfPointOccupied(field, point)) {
            throw new AlreadyOccupiedException();
        }

        field.setFigure(point, figure);

    }

    private boolean checkIfPointOccupied(final Field field, final Point point) throws InvalidCoordinateException {

        if(field.getFigure(point) != null) return true;

        return false;

    }

}

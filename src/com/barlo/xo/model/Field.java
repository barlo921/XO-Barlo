package com.barlo.xo.model;


import com.barlo.xo.model.exceptions.InvalidCordinateException;

public class Field {

    final Figure field[][];

    final int fieldSize;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public Figure getFigure(final Point point) {
        return field[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidCordinateException{
        checkPoint(point);
        field[point.getX()][point.getY()] = figure;
    }

    public void checkPoint(final Point point) throws InvalidCordinateException{
        if(checkCoordinate(point.getX()) | checkCoordinate(point.getY())) {
            throw new InvalidCordinateException();
        }
    }

    private boolean checkCoordinate(final int coordinate) {
        if(coordinate < 0 && coordinate >= fieldSize) {
            return false;
        }
        return true;
    }
}

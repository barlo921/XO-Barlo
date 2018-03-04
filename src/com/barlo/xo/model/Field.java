package com.barlo.xo.model;


import com.barlo.xo.model.exceptions.InvalidCoordinateException;

public class Field {

    private final Figure field[][];

    private final int fieldSize;

    private final int MIN_COORDINATE = 0;

    private final int MAX_COORDINATE;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
        MAX_COORDINATE = fieldSize;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public Figure getFigure(final Point point) {
        return field[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidCoordinateException {
        if(!checkPoint(point)) {
            throw new InvalidCoordinateException();
        }
        field[point.getX()][point.getY()] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.getX()) && checkCoordinate(point.getY());
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }
}

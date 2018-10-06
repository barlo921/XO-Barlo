package com.barlo.xo.view;

//Prints field in console

import com.barlo.xo.model.Field;
import com.barlo.xo.model.Point;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;

public class ConsoleView {

    private final static String BRAKE_FIGURES = "|";
    private final static String BRAKE_LINES = "-------";
    private final static String NULL_FIGURE = " ";

    final Field field;


    public ConsoleView(Field field) {
        this.field = field;
    }

    public void printField() throws InvalidCoordinateException {

        printBrakes(BRAKE_LINES);

        for (int x=0; x<field.getFieldSize(); x++) {

            printLine(x);
            printBrakes(BRAKE_LINES);
        }

    }

    private void printLine(final int line) throws InvalidCoordinateException {

        printBrakes(BRAKE_FIGURES);

        for (int y=0; y<field.getFieldSize(); y++) {
            if (field.getFigure(new Point(line, y)) != null) {
                System.out.print(field.getFigure(new Point(line, y)));
            } else {
                System.out.print(NULL_FIGURE);
            }

            printBrakes(BRAKE_FIGURES);
        }

        System.out.println();
    }

    private void printBrakes(final String brakes){
        if (brakes.equals(BRAKE_LINES)) {
            System.out.println(BRAKE_LINES);
        } else {
            System.out.print(BRAKE_FIGURES);
        }
    }

}

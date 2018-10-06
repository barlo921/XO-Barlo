package com.barlo.xo.view;

//Prints field in console

import com.barlo.xo.controllers.CurrentMoveController;
import com.barlo.xo.controllers.MoveController;
import com.barlo.xo.controllers.WinnerController;
import com.barlo.xo.model.Field;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Game;
import com.barlo.xo.model.Point;
import com.barlo.xo.model.exceptions.AlreadyOccupiedException;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final static String BRAKE_FIGURES = "|";
    private final static String BRAKE_LINES = "-------";
    private final static String NULL_FIGURE = " ";

    final Game gameXO;
    final Field field;


    public ConsoleView(Game gameXO) {
        this.gameXO = gameXO;
        field = gameXO.getField();
    }

    public void printField() throws InvalidCoordinateException {

        printBrakes(BRAKE_LINES);

        for (int x=0; x<field.getFieldSize(); x++) {

            printLine(x);
            printBrakes(BRAKE_LINES);
        }

    }

    public boolean move() {

        CurrentMoveController currentMoveController = new CurrentMoveController();
        MoveController moveController = new MoveController();
        WinnerController winnerController = new WinnerController();
        Figure currentFigure;
        Figure winner;

        try {

            winner = winnerController.getWinner(field);
            if (winner != null) {
                System.out.format("Winner is %s\n", winner);
                return false;
            }

            currentFigure = currentMoveController.currentMove(field);

            if (currentFigure == null) {
                System.out.println("Draw!");
                return false;
            }

            System.out.format("Turn for %s\n", currentFigure);

            moveController.applyFigure(field, askPoint(), currentFigure);

            return true;

        } catch (final InvalidCoordinateException | AlreadyOccupiedException e) {
            System.out.println("Point is Invalid!");
        }

        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("Line")-1, askCoordinate("Column")-1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please enter coordinate for %s\n", coordinateName);
        final Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Olololo!!!");
            return askCoordinate(coordinateName);
        }
    }

    private void invalidCoordinate(final int coordinate) throws InvalidCoordinateException {
        if (coordinate<0 && coordinate>gameXO.getField().getFieldSize())
            throw new InvalidCoordinateException();
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

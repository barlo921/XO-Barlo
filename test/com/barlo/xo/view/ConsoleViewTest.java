package com.barlo.xo.view;

import com.barlo.xo.model.Field;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Point;
import org.junit.Test;

import static org.junit.Assert.*;


public class ConsoleViewTest {

    @Test
    public void printFieldWithNoFigures() throws Exception {

        Field field = new Field(3);

        ConsoleView consoleView = new ConsoleView(field);

        consoleView.printField();

    }

    @Test
    public void printFieldWithFigures() throws Exception {

        Field field = new Field(3);

        for (int i=0; i<field.getFieldSize(); i++) {
            field.setFigure(new Point(i,i), Figure.X);
        }

        ConsoleView consoleView = new ConsoleView(field);

        consoleView.printField();

    }

}
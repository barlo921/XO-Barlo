package com.barlo.xo.view;

import com.barlo.xo.controllers.CurrentMoveController;
import com.barlo.xo.controllers.WinnerController;
import com.barlo.xo.model.Field;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Point;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class WindowView {

    private final static int CENTER_BUTTON_MODIFIER = 35;
    private final static int LINE_OFFSET_BUTTON_MODIFIER = 10;
    private final static int LINE_OFFSET_BUTTON_MODIFIER_ADD = 50;

    private static Field field;

    @FXML private Pane pane;
    @FXML private Text textField;

    public static void setField(final Field setField) {
        field = setField;
    }

    @FXML
    public void setFigure(final ActionEvent event) throws InvalidCoordinateException {

        Button handledButton = (Button) event.getSource();

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure currentFigure = currentMoveController.currentMove(field);

        WinnerController winnerController = new WinnerController();

        writeToMatrix(handledButton, currentFigure);

        switch (currentFigure) {
            case X:
                createCross(handledButton);
                break;
            case O:
                createCircle(handledButton);
                break;
        }

        handledButton.setDisable(true);

        Figure winner = winnerController.getWinner(field);

        if (winner != null) {

            switch (winner) {
                case X:
                    textField.setText("X is the Winner");
                    break;
                case O:
                    textField.setText("O is the Winner");
                    break;
            }

            pane.setDisable(true);

        } else {

            if (currentMoveController.currentMove(field) != null) {
                textField.setText("Turn for " + currentFigure);
            } else {
                textField.setText("DRAW!");
                pane.setDisable(true);
            }

        }

    }

    private void createCircle(final Button handledButton){
        final int radius = 25;
        Circle circle = new Circle((int) handledButton.getLayoutX()+CENTER_BUTTON_MODIFIER,
                                   (int) handledButton.getLayoutY()+CENTER_BUTTON_MODIFIER,
                                    radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(4);
        pane.getChildren().add(circle);

    }

    private void createCross(final Button handledButton){

        int layoutX = (int) handledButton.getLayoutX();
        int layoutY = (int) handledButton.getLayoutY();

        int startX = layoutX + LINE_OFFSET_BUTTON_MODIFIER;
        int startY = layoutY + LINE_OFFSET_BUTTON_MODIFIER;
        int endX = startX + LINE_OFFSET_BUTTON_MODIFIER_ADD;
        int endY = startY + LINE_OFFSET_BUTTON_MODIFIER_ADD;

        pane.getChildren().addAll(createLine(startX, startY, endX, endY),
                                  createLine(endX, startY, startX, endY));

    }

    private Line createLine(final int startX, final int startY, final int endX, final int endY){
        Line line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(4);
        return line;
    }

    private void writeToMatrix(final Button handledButton, final Figure currentFigure) throws InvalidCoordinateException {

        field.setFigure(new Point(defineMatrixPosition((int) handledButton.getLayoutX()), defineMatrixPosition((int) handledButton.getLayoutY())), currentFigure);

    }

    private int defineMatrixPosition(final int layout){

        switch (layout) {
            case 0:
                return 0;
            case 70:
                return 1;
            case 140:
                return 2;
            default:
                return 3;
        }

    }

}

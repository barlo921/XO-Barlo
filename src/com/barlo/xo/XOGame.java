package com.barlo.xo;


import com.barlo.xo.view.WindowView;
import com.barlo.xo.model.Figure;
import com.barlo.xo.model.Game;
import com.barlo.xo.model.Player;
import com.barlo.xo.model.exceptions.InvalidCoordinateException;
import com.barlo.xo.model.exceptions.TwoPlayersSameFigureException;
import com.barlo.xo.model.Window;
import javafx.application.Application;

public class XOGame {

    public static void main(String[] args) throws TwoPlayersSameFigureException, InvalidCoordinateException {

        Game gameXO = new Game.GameBuilder()
                                .player1(new Player("Player 1", Figure.X))
                                .player2(new Player("Player 2", Figure.O))
                                .fieldSize(3)
                                .createGame();

/*    Start for Console XO Game

       System.out.println("XO Game Begins");

       consoleView.printField();

       while (consoleView.move()) {
            consoleView.printField();
        }
*/
        WindowView.setField(gameXO.getField());
        Application.launch(Window.class, args);

    }

}

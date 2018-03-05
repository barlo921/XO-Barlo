package com.barlo.xo.model;

import com.barlo.xo.model.exceptions.TwoPlayersSameFigureException;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest {
    @Test
    public void testGetPlayer1() throws Exception {

        final String actualName = "Max";

        Game game = new GameBuilder().setPlayer1(new Player(actualName, Figure.X))
                                     .setPlayer2(new Player("Slava", Figure.O))
                                     .setFieldSize(3)
                                     .createGame();

        assertEquals(actualName, game.getPlayer1().getName());

    }

    @Test
    public void testGetPlayer2() throws Exception {

        final String actualName = "Slava";

        Game game = new GameBuilder().setPlayer1(new Player("Max", Figure.X))
                .setPlayer2(new Player(actualName, Figure.O))
                .setFieldSize(3)
                .createGame();

        assertEquals(actualName, game.getPlayer2().getName());

    }

    @Test
    public void testPlayersSameFigureX() throws Exception {

        try {

            Game game = new GameBuilder().setPlayer1(new Player("Max", Figure.X))
                    .setPlayer2(new Player("Slava", Figure.X))
                    .setFieldSize(3)
                    .createGame();

            fail();

        } catch (TwoPlayersSameFigureException e) {

        }

    }


    @Test
    public void testPlayersSameFigureO() throws Exception {

        try {

            Game game = new GameBuilder().setPlayer1(new Player("Max", Figure.O))
                    .setPlayer2(new Player("Slava", Figure.O))
                    .setFieldSize(3)
                    .createGame();

            fail();

        } catch (TwoPlayersSameFigureException e) {

        }

    }

}
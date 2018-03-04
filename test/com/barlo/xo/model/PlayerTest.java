package com.barlo.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by grigoriikutuzov on 04/03/18.
 */
public class PlayerTest {
    @Test
    public void testGetName() throws Exception {

        final String actualName = "Max";
        final Figure actualFigure = Figure.X;

        final Player player = new Player(actualName, actualFigure);

        assertEquals(actualName, player.getName());

    }

    @Test
    public void testGetPlayersFigure() throws Exception {

        final String actualName = "Max";
        final Figure actualFigure = Figure.X;

        final Player player = new Player(actualName, actualFigure);

        assertEquals(actualFigure, player.getPlayersFigure());

    }

}
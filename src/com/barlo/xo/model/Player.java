package com.barlo.xo.model;


public class Player {

    private final String name;

    private final Figure playersFigure;

    public Player(String name, Figure playersFigure) {
        this.name = name;
        this.playersFigure = playersFigure;
    }

    public String getName() {
        return name;
    }

    public Figure getPlayersFigure() {
        return playersFigure;
    }
}

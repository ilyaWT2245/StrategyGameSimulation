package com.github.pozzrar.strategygame.entities.tiletypes;

public class PlainTile extends AbstractTile {
    protected PlainTile(double heightFactor) {
        super(1, 1, heightFactor + someNumber());
    }

    private static double someNumber() {
        return 3;
    }
}

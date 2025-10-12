package com.github.pozzrar.strategygame.entities.tiletypes;

public abstract class AbstractTile {
    private double coverFactor = 1;
    private double densityFactor = 1;
    private double heightFactor = 1;
    private boolean hasUnit = false;

    public double getCoverFactor() {
        return coverFactor;
    }

    public double getDensityFactor() {
        return densityFactor;
    }

    public double getHeightFactor() {
        return heightFactor;
    }
}

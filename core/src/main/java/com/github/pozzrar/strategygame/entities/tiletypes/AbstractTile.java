package com.github.pozzrar.strategygame.entities.tiletypes;

public abstract class AbstractTile {
    private final double coverFactor;
    private final double densityFactor;
    private final double heightFactor;

    protected AbstractTile(double coverFactor, double densityFactor, double heightFactor) {
        this.coverFactor = coverFactor;
        this.densityFactor = densityFactor;
        this.heightFactor = heightFactor;
    }

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

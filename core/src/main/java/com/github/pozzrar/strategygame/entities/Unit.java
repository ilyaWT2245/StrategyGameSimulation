package com.github.pozzrar.strategygame.entities;

public class Unit {
    private double damage;
    private int range;

    public Unit(double damage, int range) {
        this.damage = damage;
        this.range = range;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setRange(int range) {
        this.range = range;
    }
}

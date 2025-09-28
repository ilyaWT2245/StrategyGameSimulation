package com.github.pozzrar.strategygame.entities;

public abstract class AbstractUnit {
    private double damage;
    private int range;
    private int quantity;
    private int actions;
    private int armour;
    // TODO: Александр - пишет юнитов
    // TODO: методы атаки, урона,


    public AbstractUnit(double damage, int range) {
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

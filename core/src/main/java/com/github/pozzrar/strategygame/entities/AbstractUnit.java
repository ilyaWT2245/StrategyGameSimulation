package com.github.pozzrar.strategygame.entities;

public abstract class AbstractUnit {
    private double damage;
    private int range;
    private int quantity;
    private int actions;
    private int armour;
    private Cell cell;
    // TODO: Александр - пишет юнитов

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setActions(int actions) {
        this.actions = actions;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public double getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getArmour() {
        return armour;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getActions() {
        return actions;
    }
}

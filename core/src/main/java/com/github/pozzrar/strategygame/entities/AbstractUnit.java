package com.github.pozzrar.strategygame.entities;

public abstract class AbstractUnit {
    private final double baseDamage;
    private final  int baseRange;
    private final int baseArmour;

    // эти свойства зависят от тайла, на котором находится юнит
    private double realDamage;
    private int realRange;
    private int realArmour;

    private int quantity;
    private int actions;
    private Cell cell;

    protected AbstractUnit(double baseDamage, int baseRange, int baseArmour) {
        this.baseDamage = baseDamage;
        this.baseRange = baseRange;
        this.baseArmour = baseArmour;
    }
    // TODO: Александр - пишет юнитов

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setActions(int actions) {
        this.actions = actions;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setRealArmour(int realArmour) {
        this.realArmour = realArmour;
    }

    public void setRealDamage(double realDamage) {
        this.realDamage = realDamage;
    }

    public void setRealRange(int realRange) {
        this.realRange = realRange;
    }

    public Cell getCell() {
        return cell;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public int getBaseRange() {
        return baseRange;
    }

    public int getBaseArmour() {
        return baseArmour;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getActions() {
        return actions;
    }
}

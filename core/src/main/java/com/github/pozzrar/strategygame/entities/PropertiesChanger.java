package com.github.pozzrar.strategygame.entities;

public class PropertiesChanger {
    private final Tile tile;
    private Unit unit;

    public PropertiesChanger(Tile tile, Unit unit) {
        this.tile = tile;
        this.unit = unit;
    }

    public void changeProperties() {
        // TODO: здесь можно будет менять порядок изменения параметров юнита
        // TODO: также тут учет брони юнита
    }

    // названия говорят сами за себя
    private void changeDamage() {

    }

    private void changeRange() {

    }

    private void changeQuantity() {

    }
}

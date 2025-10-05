package com.github.pozzrar.strategygame.interaction;

import com.github.pozzrar.strategygame.entities.Unit;

public class UnitInteraction {
    private Unit activeUnit;
    private Unit unitToChange;
    private PropertiesChanger propertiesChanger;

    // TODO: разные методы взаимодействия юнитов
    public void attack() {

    }

    public void setActiveUnit(Unit activeUnit) {
        this.activeUnit = activeUnit;
    }

    public void setUnitToChange(Unit unitToChange) {
        this.unitToChange = unitToChange;
    }
}

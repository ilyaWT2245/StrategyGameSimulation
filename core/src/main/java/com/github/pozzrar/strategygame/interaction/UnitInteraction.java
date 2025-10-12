package com.github.pozzrar.strategygame.interaction;

import com.github.pozzrar.strategygame.entities.AbstractUnit;

public class UnitInteraction {
    private AbstractUnit activeUnit;
    private AbstractUnit unitToChange;

    // TODO: разные методы взаимодействия юнитов
    public void attack(AbstractUnit attacker, AbstractUnit victim) {
        // TODO: добавить формулу вычисления дамага
        if (canInteract()) {
            int damage = 0; // заглушка
            victim.setQuantity(victim.getQuantity() - damage);
        }

        attacker.setActions(attacker.getActions() - 1);
    }

    private boolean canInteract() {
        // TODO: сделать проверку может ли юнит взаимодействовать с другим(хватает ли дальности, есть ли ходы)
        return true;
    }

    public void setActiveUnit(AbstractUnit activeUnit) {
        this.activeUnit = activeUnit;
    }

    public void setUnitToChange(AbstractUnit unitToChange) {
        this.unitToChange = unitToChange;
    }
}

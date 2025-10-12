package com.github.pozzrar.strategygame.interaction;

import com.github.pozzrar.strategygame.entities.AbstractUnit;
import com.github.pozzrar.strategygame.entities.Cell;
import com.github.pozzrar.strategygame.entities.Unit;

public class PropertiesChanger {
    private AbstractUnit unit;

    public void changeProperties(AbstractUnit unit) {
        // TODO: здесь можно будет менять порядок изменения параметров юнита
        // TODO: также тут учет брони юнита
        this.unit = unit;
    }

    // названия говорят сами за себя
    private void changeDamage() {

    }

    private void changeRange() {
        // TODO: добавить метод
    }

    private void changeQuantity() {

    }

    private void changeArmour() {
        unit.setArmour((int) (unit.getArmour() * unit.getCell().getTileType().getCoverFactor()));
    }

    private void changeActions() {
        // TODO: поиграться с формулой

        unit.setActions((int) (unit.getActions() - Math.log(unit.getCell().getTileType().getDensityFactor())));
    }
}

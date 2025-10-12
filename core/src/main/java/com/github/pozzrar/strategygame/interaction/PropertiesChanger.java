package com.github.pozzrar.strategygame.interaction;

import com.github.pozzrar.strategygame.entities.AbstractUnit;

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
        double factor = unit.getCell().getTileType().getCoverFactor();
        unit.setRealArmour((int) (unit.getBaseArmour() * factor));
    }

    private void changeActions() {
        // TODO: поиграться с формулой

        int reduce = (int) Math.log(unit.getCell().getTileType().getDensityFactor());
        unit.setActions(unit.getActions() - reduce);
    }
}

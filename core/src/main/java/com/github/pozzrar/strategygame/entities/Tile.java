package com.github.pozzrar.strategygame.entities;

import java.util.HashMap;

public class Tile {
    // СПИСОК ВИДОВ ТАЙЛОВ
    private final String[] TILE_TYPES = new String[]{
        "River",
        "Plain",
        "Forest",
        "Swamp",
        "Hill",
    };

    private final int coordinateX;
    private final int coordinateY;
    private HashMap<String, Boolean> tileProperties = new HashMap<>();

    // ------------КОНСТРУКТОРЫ--------------

    // Пустой тайл
    public Tile(int x, int y) {
        this(new String[]{}, x, y);
    }

    public Tile(String[] types, int x, int y) {
        coordinateX = x;
        coordinateY = y;
        for (String type : TILE_TYPES) {
            boolean hasProperty = false;
            for (String property : types) {
                if (property.equals(type)) {
                    hasProperty = true;
                    break;
                }
            }
            tileProperties.put(type, hasProperty);
        }
    }

    // ------------МЕТОДЫ--------------

    /**
     * Изменение атаки юнита, в зависимости от свойств тайла
     * @param unit юнит
     */
    public void changeDamage(Unit unit) {
        // TODO: добавить метод изменения атаки
    }

    /**
     * Изменение дальности юнита, в зависимости от свойств тайла
     * @param unit юнит
     */
    public void changeRange(Unit unit) {
        // TODO: добавить метод изменения дальности
    }

    public int getX() {
        return coordinateX;
    }
    public int getY() {
        return coordinateY;
    }

    public HashMap<String, Boolean> getTileProperties() {
        return tileProperties;
    }
}

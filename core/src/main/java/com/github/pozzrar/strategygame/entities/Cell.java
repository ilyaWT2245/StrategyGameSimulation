package com.github.pozzrar.strategygame.entities;

import com.github.pozzrar.strategygame.entities.tiletypes.AbstractTile;

public class Cell {
    private final AbstractTile tileType;
    private final int coordinateX;
    private final int coordinateY;

    // ------------КОНСТРУКТОРЫ--------------

    // Пустая клетка
    public Cell(int x, int y) {
        this(null, x, y);
    }

    public Cell(AbstractTile type, int x, int y) {
        coordinateX = x;
        coordinateY = y;
        tileType = type;
    }

    // ------------МЕТОДЫ--------------


    public int getX() {
        return coordinateX;
    }
    public int getY() {
        return coordinateY;
    }

    public AbstractTile getTileType() {
        return tileType;
    }
}

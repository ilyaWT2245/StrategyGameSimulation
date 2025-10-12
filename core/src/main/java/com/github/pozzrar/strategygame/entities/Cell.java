package com.github.pozzrar.strategygame.entities;

public class Cell {
    private final Tile tileType;
    private final int coordinateX;
    private final int coordinateY;

    // ------------КОНСТРУКТОРЫ--------------

    // Пустая клетка
    public Cell(int x, int y) {
        this(null, x, y);
    }

    public Cell(Tile type, int x, int y) {
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

    public Tile getTileType() {
        return tileType;
    }
}

package com.github.pozzrar.strategygame.entities;

public class GameMap {
    private final int MAP_WIDTH = 20;
    private final int MAP_HEIGHT = 20;

    private Tile[][] tileMap = new Tile[MAP_WIDTH][MAP_HEIGHT];
    // ------------КОНСТРУКТОРЫ--------------

    public GameMap() {
        generate();
    }

    // ------------МЕТОДЫ--------------

    /**
     * Генерация карты
     */
    private void generate() {
        // TODO: здеся будет наполнение поля tileMap(возможно добавление параметров)
    }
}

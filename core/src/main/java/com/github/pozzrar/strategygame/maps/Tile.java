package com.github.pozzrar.strategygame.maps;

import com.badlogic.gdx.graphics.Color;

/**
 * Represents a single tile in the game map.
 */
public class Tile {
    public enum TileType {
        BLACK(Color.BLACK),
        WHITE(Color.WHITE);

        public final Color color;

        TileType(Color color) {
            this.color = color;
        }
    }

    private final TileType type;
    private final int x;
    private final int y;

    public Tile(int x, int y, TileType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    public Color getColor() {
        return type.color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

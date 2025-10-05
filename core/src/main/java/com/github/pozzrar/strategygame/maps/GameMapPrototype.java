package com.github.pozzrar.strategygame.maps;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

/**
 * Represents a 2D tile-based map with random generation.
 */
public class GameMapPrototype {
    public static final int TILE_SIZE = 32; // Size of each tile in pixels

    private final int WIDTH;
    private final int HEIGHT;
    private final Tile[][] tiles;
    private final Random random;

    public GameMapPrototype(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.tiles = new Tile[width][height];
        this.random = new Random();
        generateMap();
    }

    public GameMapPrototype(int width, int height, long seed) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.tiles = new Tile[width][height];
        this.random = new Random(seed);
        generateMap();
    }

    private void generateMap() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Tile.TileType type = random.nextBoolean() ? Tile.TileType.BLACK : Tile.TileType.WHITE;
                tiles[x][y] = new Tile(x, y, type);
            }
        }
    }

    // TODO: вынести метод в отдельное место(типа MapRenderer или чето такое)
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Tile tile = tiles[x][y];
                shapeRenderer.setColor(tile.getColor());
                shapeRenderer.rect(
                    x * TILE_SIZE,
                    y * TILE_SIZE,
                    TILE_SIZE,
                    TILE_SIZE
                );
            }
        }

        shapeRenderer.end();
    }

    public Tile getTile(int x, int y) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            return tiles[x][y];
        }
        return null;
    }

    /* эта реализация должна быть более гибкая
    public Tile getTile(int x, int y) {
        return tiles[x % WIDTH][y % HEIGHT];
    }
     */

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getPixelWidth() {
        return WIDTH * TILE_SIZE;
    }

    public int getPixelHeight() {
        return HEIGHT * TILE_SIZE;
    }
}

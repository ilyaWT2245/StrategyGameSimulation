package com.github.pozzrar.strategygame.maps;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

/**
 * Represents a 2D tile-based map with random generation.
 */
public class GameMapPrototype {
    public static final int TILE_SIZE = 32; // Size of each tile in pixels

    private final int width;
    private final int height;
    private final Tile[][] tiles;
    private final Random random;

    public GameMapPrototype(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        this.random = new Random();
        generateMap();
    }

    public GameMapPrototype(int width, int height, long seed) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        this.random = new Random(seed);
        generateMap();
    }

    private void generateMap() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Tile.TileType type = random.nextBoolean() ? Tile.TileType.BLACK : Tile.TileType.WHITE;
                tiles[x][y] = new Tile(x, y, type);
            }
        }
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
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
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return tiles[x][y];
        }
        return null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPixelWidth() {
        return width * TILE_SIZE;
    }

    public int getPixelHeight() {
        return height * TILE_SIZE;
    }
}

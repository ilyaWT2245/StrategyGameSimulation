package com.github.pozzrar.strategygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.github.pozzrar.strategygame.maps.GameMapPrototype;
import com.github.pozzrar.strategygame.modules.GameCamera;
import com.github.pozzrar.strategygame.modules.InputHandler;

/** First screen of the application. Displays the tile-based map with camera controls. */
public class FirstScreen implements Screen {
    private GameMapPrototype gameMapPrototype;
    private GameCamera gameCamera;
    private ShapeRenderer shapeRenderer;
    private InputHandler inputHandler;

    // Map dimensions (in tiles)
    private static final int MAP_WIDTH = 100;
    private static final int MAP_HEIGHT = 100;

    @Override
    public void show() {
        // Initialize the map with random tiles
        gameMapPrototype = new GameMapPrototype(MAP_WIDTH, MAP_HEIGHT);

        // Initialize camera
        gameCamera = new GameCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        gameCamera.setMapBounds(gameMapPrototype.getPixelWidth(), gameMapPrototype.getPixelHeight());

        // Initialize shape renderer for drawing tiles
        shapeRenderer = new ShapeRenderer();

        // Set up input handling
        inputHandler = new InputHandler(gameCamera);
        Gdx.input.setInputProcessor(inputHandler);
    }

    @Override
    public void render(float delta) {
        // Update camera
        gameCamera.update(delta);

        // Clear the screen
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Set the camera's projection matrix
        shapeRenderer.setProjectionMatrix(gameCamera.getCamera().combined);

        // Render the map
        gameMapPrototype.render(shapeRenderer);
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0) return;

        // Update camera viewport
        gameCamera.resize(width, height);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        if (shapeRenderer != null) {
            shapeRenderer.dispose();
        }
    }
}

package com.github.pozzrar.strategygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.pozzrar.strategygame.entities.GameMap;
import com.github.pozzrar.strategygame.entities.MapLoader;

import java.util.HashMap;
import java.util.Map;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GDXGame extends Game {

    public static final int WORLD_WIDTH = 800;
    public static final int WORLD_HEIGHT = 608;

    private Batch batch;
    private OrthographicCamera camera;
    private Viewport viewport;
    private MapLoader mapLoader;

    private final Map<Class<? extends Screen>, Screen> screenCache = new HashMap<>();

    @Override
    public void create() {
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        this.mapLoader = new MapLoader(new GameMap());

        addScreen(new GameScreen(this));
        setScreen(GameScreen.class);
    }

    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height, true);
        super.resize(width, height);
    }

    public void addScreen(Screen screen) {
        screenCache.put(screen.getClass(), screen);
    }

    public void setScreen(Class<? extends Screen> screenClass) {
        Screen screen = screenCache.get(screenClass);
        if (screen == null) {
            throw new GdxRuntimeException("No such screen with this class " + screenClass);
        }
        super.setScreen(screen);
    }

    @Override
    public void dispose() {
        this.screenCache.values().forEach(Screen::dispose);
        this.screen.dispose();

        this.batch.dispose();
        super.dispose();
    }

    public Batch getBatch() {
        return batch;
    }

    public Viewport getViewport() {
        return viewport;
    }

    @Override
    public Screen getScreen() {
        return super.getScreen();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public MapLoader getMapLoader() {
        return mapLoader;
    }
}

package com.github.pozzrar.strategygame;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.pozzrar.strategygame.entities.AbstractMapLoader;

public class GameScreen extends ScreenAdapter {
    private final GDXGame game;
    private final AbstractMapLoader mapLoader;
    private final OrthographicCamera camera;
    private final Viewport viewport;

    public GameScreen(GDXGame game) {
        this.game = game;
        this.camera = game.getCamera();
        this.viewport = game.getViewport();
        this.mapLoader = game.getMapLoader();
    }

    @Override
    public void show() {
        mapLoader.load();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}

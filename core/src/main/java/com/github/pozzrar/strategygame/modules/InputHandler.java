package com.github.pozzrar.strategygame.modules;

import com.badlogic.gdx.InputProcessor;

/**
 * Handles input events for the game, particularly mouse scroll for camera zoom.
 */
public class InputHandler implements InputProcessor {
    private final GameCamera gameCamera;
    private static final float ZOOM_SPEED = 0.1f;

    public InputHandler(GameCamera gameCamera) {
        this.gameCamera = gameCamera;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        // Handle mouse wheel scrolling for zoom
        float zoomChange = amountY * ZOOM_SPEED;
        float newZoom = gameCamera.getZoom() + zoomChange;
        gameCamera.setZoom(newZoom);
        return true;
    }
}

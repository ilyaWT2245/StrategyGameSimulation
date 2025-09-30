package com.github.pozzrar.strategygame.modules;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

/**
 * Camera wrapper that handles mouse-based movement and zoom functionality.
 */
public class GameCamera {
    private final OrthographicCamera camera;

    // Camera movement settings
    private static final float CAMERA_SPEED = 200f; // pixels per second
    private static final int EDGE_MARGIN = 50; // pixels from edge to trigger movement

    // Zoom settings
    private static final float MIN_ZOOM = 0.5f;
    private static final float MAX_ZOOM = 3.0f;
    private static final float ZOOM_SPEED = 0.1f;

    // Map boundaries
    private float mapWidth;
    private float mapHeight;

    public GameCamera(float viewportWidth, float viewportHeight) {
        camera = new OrthographicCamera(viewportWidth, viewportHeight);
        camera.position.set(viewportWidth / 2f, viewportHeight / 2f, 0);
        camera.update();
    }

    public void setMapBounds(float mapWidth, float mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public void update(float delta) {
        handleMouseMovement(delta);
        clampToMapBounds();
        camera.update();
    }

    private void handleMouseMovement(float delta) {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.input.getY();
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();

        float moveSpeed = CAMERA_SPEED * camera.zoom * delta;

        // Move camera based on mouse position near screen edges
        if (mouseX < EDGE_MARGIN) {
            // Left edge - move camera left
            camera.position.x -= moveSpeed;
        } else if (mouseX > screenWidth - EDGE_MARGIN) {
            // Right edge - move camera right
            camera.position.x += moveSpeed;
        }

        if (mouseY < EDGE_MARGIN) {
            // Top edge (remember Y is inverted in screen coordinates) - move camera up
            camera.position.y += moveSpeed;
        } else if (mouseY > screenHeight - EDGE_MARGIN) {
            // Bottom edge - move camera down
            camera.position.y -= moveSpeed;
        }
    }


    private void clampToMapBounds() {
        if (mapWidth <= 0 || mapHeight <= 0) return;

        float halfWidth = camera.viewportWidth * camera.zoom / 2f;
        float halfHeight = camera.viewportHeight * camera.zoom / 2f;

        // Clamp camera position to map boundaries
        camera.position.x = MathUtils.clamp(camera.position.x,
            halfWidth,
            mapWidth - halfWidth);
        camera.position.y = MathUtils.clamp(camera.position.y,
            halfHeight,
            mapHeight - halfHeight);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    public Vector3 getPosition() {
        return camera.position;
    }

    public float getZoom() {
        return camera.zoom;
    }

    public void setPosition(float x, float y) {
        camera.position.set(x, y, 0);
    }

    public void setZoom(float zoom) {
        camera.zoom = MathUtils.clamp(zoom, MIN_ZOOM, MAX_ZOOM);
    }
}

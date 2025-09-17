package com.github.pozzrar.strategygame;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GDXGame extends Game {
    @Override
    public void create() {
        setScreen(new FirstScreen());
    }
}
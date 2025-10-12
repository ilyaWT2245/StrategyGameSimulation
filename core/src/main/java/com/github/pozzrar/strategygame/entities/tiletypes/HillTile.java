package com.github.pozzrar.strategygame.entities.tiletypes;

import java.util.Random;

public class HillTile extends AbstractTile{
    protected HillTile(double heightFactor) {
        super(1, 1, heightFactor);
    }

//    private static double setRandomHeight() {
//        Random r = new Random();
//        int maxHeight = 5;
//        return r.nextInt(maxHeight - 1) + 1;
//    }
}

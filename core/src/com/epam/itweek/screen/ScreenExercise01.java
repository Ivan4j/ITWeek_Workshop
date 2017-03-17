package com.epam.itweek.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public class ScreenExercise01 extends AbstractScreen {

    @Override
    public void render() {

        // Color to clear the screen
        //Use float values between 0 and 1
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

}

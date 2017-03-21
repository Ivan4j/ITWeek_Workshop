package com.epam.itweek.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.epam.itweek.utils.Constants;

/**
 * Exercise #01: Background Image
 *
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public class ScreenExercise01 extends AbstractScreen {

    private Texture backgroundTexture;

    public ScreenExercise01() {

        backgroundTexture = new Texture(Gdx.files.internal("img/background_low_poly.png"));

    }

    @Override
    public void render() {

        spriteBatch.begin();

            //Draw a white image as background
            spriteBatch.draw(backgroundTexture, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        spriteBatch.end();

    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
    }

}

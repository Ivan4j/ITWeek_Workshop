package com.epam.itweek.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epam.itweek.utils.Constants;

/**
 * Exercise #02: Draw a game Object (Sprite)
 *
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public class ScreenExercise02 extends AbstractScreen {

    private Texture backgroundTexture;

    private Sprite androidSprite;
    private Texture androidTexture;

    public ScreenExercise02() {

        backgroundTexture = new Texture(Gdx.files.internal("img/background_low_poly.png"));

        androidTexture = new Texture(Gdx.files.internal("img/characters/Android_Robot_100.png"));
        androidTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        androidSprite = new Sprite(androidTexture);

    }
    @Override
    public void render() {

        spriteBatch.begin();

            //Draw a white image as background
            spriteBatch.draw(backgroundTexture, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

            //Draw the game object
            androidSprite.draw(spriteBatch);

        spriteBatch.end();

    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        androidTexture.dispose();
    }

}

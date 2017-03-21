package com.epam.itweek.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.epam.itweek.model.GameObject;
import com.epam.itweek.utils.Constants;

/**
 * Exercise #02: Draw a game Object (GameObject extends Sprite)
 *
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public class ScreenExercise02b extends AbstractScreen {

    private Texture backgroundTexture;

    private GameObject androidSprite;
    private Texture androidTexture;

    public ScreenExercise02b() {

        backgroundTexture = new Texture(Gdx.files.internal("img/background_low_poly.png"));

        androidTexture = new Texture(Gdx.files.internal("img/characters/Android_Robot_100.png"));
        androidTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        androidSprite = new GameObject(androidTexture);

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

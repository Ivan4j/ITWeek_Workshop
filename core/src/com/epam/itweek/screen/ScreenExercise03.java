package com.epam.itweek.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epam.itweek.utils.Constants;

/**
 * Exercise #03: Change position, scale and rotation
 *
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public class ScreenExercise03 extends AbstractScreen {

    private Texture backgroundTexture;

    private Sprite androidSprite;
    private Texture androidTexture;

    public ScreenExercise03() {

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

            //Move the object to the desired position
            androidSprite.setPosition(200, 400);

            //Set a fixed angle
            androidSprite.setRotation(45);

            //Double size
            androidSprite.setScale(2f);

        spriteBatch.end();

    }

}

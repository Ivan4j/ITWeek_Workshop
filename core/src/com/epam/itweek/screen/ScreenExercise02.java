package com.epam.itweek.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epam.itweek.utils.Constants;

/**
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public class ScreenExercise02 extends AbstractScreen {

    protected Sprite backgroundSprite;
    protected Texture backgroundTexture;

    public ScreenExercise02() {
        backgroundTexture = new Texture(Gdx.files.internal("img/background_low_poly.png"));
        backgroundTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setBounds(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

    }
    @Override
    public void render() {

        //Draw a white image as background
        spriteBatch.begin();
        backgroundSprite.draw(spriteBatch);
        spriteBatch.end();

    }

}

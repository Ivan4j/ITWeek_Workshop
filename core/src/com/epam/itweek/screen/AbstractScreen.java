package com.epam.itweek.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.epam.itweek.ITWeekGame;
import com.epam.itweek.controller.UIController;
import com.epam.itweek.ui.Button;

/**
 *
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public abstract class AbstractScreen implements Screen {

    protected SpriteBatch spriteBatch;
    protected SpriteBatch uiBatch;
    protected Array<Button> uiComponents;
    protected UIController uiController;

    public AbstractScreen() {

        spriteBatch = ITWeekGame.getSpriteBatch();
        uiBatch = ITWeekGame.getSpriteBatch();
        uiComponents = new Array<Button>();
        uiController = new UIController(uiComponents);

        Gdx.input.setInputProcessor(uiController);
    }

    @Override
    public void show() {

    }

    @Override
    public final void render(float delta) {

        // Color to clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        render();
        renderUI();
    }

    public void renderUI() {

        uiBatch.begin();

        for(Button ui : uiComponents) {
            ui.draw(ITWeekGame.getSpriteBatch());
        }

        uiBatch.end();
    }
    public abstract void render();

    @Override
    public void resize(int width, int height) {
        ITWeekGame.getViewport().update(width, height, true);
        ITWeekGame.getCamera().update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

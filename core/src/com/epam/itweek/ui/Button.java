package com.epam.itweek.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epam.itweek.ui.action.IAction;
import com.epam.itweek.utils.Constants;

/**
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public class Button extends Sprite {

    private Texture texture;
    private ButtonType type;

    private IAction action;

    public Button(ButtonType type) {

        this.type = type;
        setTexture();
    }

    private void setTexture() {

        switch(type) {

            case OK:
                texture = new Texture(Gdx.files.internal(Constants.BUTTON_OK));
                break;
            case CANCEL:
                texture = new Texture(Gdx.files.internal(Constants.BUTTON_CANCEL));
                break;
            case START:
                texture = new Texture(Gdx.files.internal(Constants.BUTTON_START));
                break;
            case RESTART:
                texture = new Texture(Gdx.files.internal(Constants.BUTTON_RESTART));
                break;
            case PAUSE:
                texture = new Texture(Gdx.files.internal(Constants.BUTTON_PAUSE));
                break;
            case BACK:
                texture = new Texture(Gdx.files.internal(Constants.BUTTON_BACK));
                break;
            case NONE:
                texture = new Texture(Gdx.files.internal(Constants.BUTTON_NONE));
                break;
        }

        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        setTexture(texture);
        this.setRegion(0, 0, texture.getWidth(), texture.getHeight());
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public void executeAction() {

        if(this.action != null) {
            this.action.execute();
        } else
            System.err.println("Action NULL, please set an action to this button");
    }
}

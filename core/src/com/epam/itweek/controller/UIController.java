package com.epam.itweek.controller;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.epam.itweek.ITWeekGame;
import com.epam.itweek.ui.Button;
import com.epam.itweek.utils.MathUtils;
import com.epam.itweek.utils.SpriteAccessor;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Back;

/**
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public class UIController implements InputProcessor {

    Vector3 touchPoint = new Vector3();
    boolean dragging;

    private Array<Button> uiCopmponents;

    private Button uiSelected = null;

    public UIController(Array<Button> screenUIComponents) {

        this.uiCopmponents = screenUIComponents;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        touchPoint = ITWeekGame.getViewport().unproject(new Vector3(screenX,screenY,0));

        dragging = true;

        uiSelected = null;

        for(Button ui : this.uiCopmponents) {
            if (MathUtils.checkTouchCollision(touchPoint, ui.getBoundingRectangle())) {

                uiSelected = ui;

                System.out.println("Touched");
                animateComponentIN(ui);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        touchPoint = ITWeekGame.getViewport().unproject(new Vector3(screenX,screenY,0));
        if (dragging && uiSelected != null) {
            for (Button ui : this.uiCopmponents) {
                if (MathUtils.checkTouchCollision(touchPoint, ui.getBoundingRectangle())) {

                    System.out.println("Touched");
                    if(ui == uiSelected) {
                        animateComponentOUT(ui, true);
                        dragging = false;
                        uiSelected = null;
                        return true;
                    }
                }
            }
        }

        if(uiSelected != null)
            animateComponentOUT(uiSelected);

        dragging = false;

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        /*
        if (!dragging)
            return false;

        touchPoint = ITWeekGame.getViewport().unproject(new Vector3(screenX,screenY,0));
        */
        return false;
    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }


    public void animateComponentIN(Button component) {

        component.setScale(1);

        Tween.to(component, SpriteAccessor.SCALE_XY, 0.15f)
                .target(1.15f, 1.15f)
                .ease(Back.INOUT)
                .start(ITWeekGame.getTweenManager());

        System.out.println("Animate IN");

    }
    public void animateComponentOUT(final Button component) {
        animateComponentOUT(component, false);
    }

    public void animateComponentOUT(final Button component, final boolean executeAction) {

        Tween.to(component, SpriteAccessor.SCALE_XY, 0.2f)
                .target(1f, 1f)
                .ease(Back.INOUT)
                .setCallback(new TweenCallback() {
                    @Override
                    public void onEvent(int i, BaseTween<?> baseTween) {
                        if(executeAction)
                            if(component instanceof Button)
                                ((Button) component).executeAction();
                    }
                })
                .start(ITWeekGame.getTweenManager());

        System.out.println("Animate OUT");

    }

}

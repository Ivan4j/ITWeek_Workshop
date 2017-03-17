package com.epam.itweek;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.epam.itweek.screen.ScreenExercise00;
import com.epam.itweek.screen.ScreenExercise01;
import com.epam.itweek.screen.ScreenExercise02;
import com.epam.itweek.utils.Constants;
import com.epam.itweek.utils.SpriteAccessor;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class ITWeekGame extends Game {

	private static Camera camera;
	private static SpriteBatch batch;
	private static TweenManager tweenManager;
	private static Viewport viewport;

	@Override
	public void create () {

		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, camera);
		viewport.apply();

		tweenManager = new TweenManager();

		Tween.registerAccessor(Sprite.class, new SpriteAccessor());

		this.setScreen(new ScreenExercise02());

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		tweenManager.update(Gdx.graphics.getDeltaTime());

		/*
		batch.begin();
			batch.draw(img, Gdx.graphics.getWidth() / 2 - img.getWidth() / 2, Gdx.graphics.getHeight() / 2 - img.getHeight() / 2);
		batch.end();
		*/

		getScreen().render(Gdx.graphics.getDeltaTime());
	}

	public void resize(int width, int height) {
		viewport.update(width, height, true);
		camera.update();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	public static SpriteBatch getSpriteBatch() {
		if(batch == null)
			batch = new SpriteBatch();
		return batch;
	}

	public static Camera getCamera() {
		if(camera == null)
			camera = new OrthographicCamera();
		return camera;
	}

	public static TweenManager getTweenManager() {
		if(tweenManager == null)
			tweenManager = new TweenManager();
		return tweenManager;
	}

	public static Viewport getViewport() {
		if(viewport == null) {
			viewport = new FitViewport(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, camera);
			viewport.apply();
		}
		return viewport;
	}
}

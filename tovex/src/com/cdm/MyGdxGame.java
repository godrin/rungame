package com.cdm;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class MyGdxGame implements ApplicationListener {
	private Level level;
	private LevelView levelView;
	private Controller controller;

	@Override
	public void create() {
		level = LevelReader.read("data/level.txt");
		levelView = new LevelView(level);
		controller = new GameController(level);
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		controller.render(Gdx.graphics.getDeltaTime());

		levelView.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}

package com.cdm;

public class GameController extends Controller {

	private Level level;

	public GameController(Level pLevel) {
		level = pLevel;
	}

	@Override
	public void render(float delta) {
		level.move(delta);
	}

}

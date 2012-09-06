package com.cdm;

import java.util.List;

public class GameController extends Controller {

	private Level level;
	private LevelView levelView;
	private Player selectedPlayer;

	public GameController(Level pLevel, LevelView view) {
		level = pLevel;
		levelView = view;
	}

	@Override
	public void render(float delta) {
		level.move(delta);
	}

	public boolean touchDown(int x, int y, int pointer, int button) {
		Position p = levelView.unproject(x, y);

		selectedPlayer = level.getPlayer(p);

		level.updateSinglePlayerDistance(selectedPlayer);
		return false;
	}

	public boolean touchDragged(int x, int y, int pointer) {
		Position p = levelView.unproject(x, y);

		List<Position> ps = level.getPathToPlayer(p);

		level.setPoints(ps);

		return false;
	}

}

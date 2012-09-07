package com.cdm;

import java.util.ArrayList;
import java.util.List;

public class GameController extends Controller {

	private Level level;
	private LevelView levelView;
	private Player selectedPlayer;
	private List<Position> drawnPositions = new ArrayList<Position>();

	public GameController(Level pLevel, LevelView view) {
		level = pLevel;
		levelView = view;
	}

	@Override
	public void render(float delta) {
		level.move(delta);
	}

	public boolean touchDown(int x, int y, int pointer, int button) {
		System.out.println("touch down");
		Position p = levelView.unproject(x, y);
		drawnPositions.clear();
		drawnPositions.add(new Position(p.alignToGrid()));

		selectedPlayer = level.getPlayer(p);

		level.updateSinglePlayerDistance(selectedPlayer);
		return false;
	}

	public boolean touchDragged(int x, int y, int pointer) {
		Position p = levelView.unproject(x, y).alignToGrid();

		if (drawnPositions.size() > 0) {
			Position last = drawnPositions.get(drawnPositions.size() - 1);
			float distance = p.distance2To(last);
			System.out.println("DIST " + distance + " " + p + " " + last);
			if (distance > p.MIN_DISTANCE && distance < 1 + p.MIN_DISTANCE
					&& level.posValid(p) && level.get(p).fieldType.isPassable()) {

				drawnPositions.add(new Position(p));
			}
			// List<Position> ps = level.getPathToPlayer(p);

			level.setPoints(drawnPositions);
		}
		return false;
	}

	public boolean touchUp(int x, int y, int pointer, int button) {
		if (selectedPlayer != null) {
			selectedPlayer.setJob(level.getPoints());
		}

		level.setPoints(new ArrayList<Position>());
		return false;
	}

}

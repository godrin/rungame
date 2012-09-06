package com.cdm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cdm.BreadthSearch.Accessor;

public class Level extends LevelMap {
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Player> players = new ArrayList<Player>();
	private List<Position> points = new ArrayList<Position>();
	private PlayerDistanceAccessor playerDistanceAccessor = new PlayerDistanceAccessor(
			this);
	private Accessor singlePlayerDistanceAccessor = new SinglePlayerDistanceAccessor(
			this);

	public Level(int pw, int ph) {
		super(pw, ph);
	}

	public void add(Entity player) {
		if (player instanceof Player)
			players.add((Player) player);
		entities.add(player);
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public List<Position> getPoints() {
		return points;
	}

	public void move(float delta) {
		for (Entity entity : entities) {
			entity.move(delta);
		}

	}

	public void updatePlayerDistance() {
		BreadthSearch.doit(this, players, playerDistanceAccessor);
	}

	public Player getPlayer(Position pos) {
		for (Player p : players) {
			Position playerPos = p.getPosition();
			if (playerPos.distance2To(pos) < 1) {
				return p;
			}
		}
		return null;
	}

	public void updateSinglePlayerDistance(Player selectedPlayer) {
		BreadthSearch.doit(this,
				Arrays.asList(new Player[] { selectedPlayer }),
				singlePlayerDistanceAccessor);
		

	}

	public List<Position> getPathToPlayer(Position p) {
		p.alignToGrid();
		return BreadthSearch.pathToZero(p, singlePlayerDistanceAccessor);
	}

	public void setPoints(List<Position> ps) {
		points = ps;
	}

	public Cell get(Position p) {
		return getCell((int)p.x, (int)p.y);
	}
}

package com.cdm;

public class PlayerDistanceAccessor implements BreadthSearch.Accessor {
	private LevelMap map;

	public PlayerDistanceAccessor(LevelMap m) {
		map = m;
	}

	@Override
	public float get(Position p) {
		return map.getCell((int) p.x, (int) p.y).distanceToPlayer;
	}

	@Override
	public void set(Position p, float v) {
		map.getCell((int) p.x, (int) p.y).distanceToPlayer = v;

	}

	@Override
	public boolean passable(Position p) {
		return map.getCell((int) p.x, (int) p.y).fieldType.isPassable();
	}

}

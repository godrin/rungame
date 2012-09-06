package com.cdm;

import com.cdm.LevelMap.Cell;

public class SinglePlayerDistanceAccessor implements BreadthSearch.Accessor {
	private LevelMap map;

	public SinglePlayerDistanceAccessor(LevelMap m) {
		map = m;
	}

	@Override
	public float get(Position p) {
		return map.getCell((int) p.x, (int) p.y).distanceToSinglePlayer;
	}

	@Override
	public void set(Position p, float v) {
		map.getCell((int) p.x, (int) p.y).distanceToSinglePlayer = v;

	}

	@Override
	public boolean passable(Position p) {
		Cell cell = map.getCell((int) p.x, (int) p.y);
		if (cell == null)
			return false;
		return cell.fieldType.isPassable();

	}

}

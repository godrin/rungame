package com.cdm;

import java.util.ArrayList;
import java.util.List;

public class BreadthSearch {
	interface Accessor {
		float get(Position p);

		void set(Position p, float v);

		boolean passable(Position neighbor);
	}

	private static Position curPos = new Position();
	private static Position[] neighbors = new Position[] { new Position(),
			new Position(), new Position(), new Position() };
	private static RoundQueue todoBuffer = new RoundQueue(128 * 128);

	public static void doit(LevelMap map,
			List<? extends Entity> startPositions, Accessor accessor) {
		for (int x = 0; x < map.width(); x++) {
			for (int y = 0; y < map.height(); y++) {
				curPos.set(x, y);
				accessor.set(curPos, -1);
			}
		}
		todoBuffer.cleanup();
		for (int i = 0; i < startPositions.size(); i++) {
			Entity entity = startPositions.get(i);
			if (entity != null) {
				Position p = entity.getPosition();
				todoBuffer.add(p);
				accessor.set(p, 0);
			}
		}
		while (todoBuffer.size() > 0) {
			Position p = todoBuffer.first();

			todoBuffer.removeFirst();
			p.getNeighbors(neighbors);
			float curValue = accessor.get(p);
			float nextValue = curValue + 1;

			for (int ni = 0; ni < 4; ni++) {
				Position neighbor = neighbors[ni];
				if (map.posValid(neighbor) && accessor.passable(neighbor))
					if (accessor.get(neighbor) < 0) {
						accessor.set(neighbor, nextValue);
						todoBuffer.add(neighbor);
					}
			}
		}
		if (false)
			for (int y = 0; y < map.height(); y++) {
				for (int x = 0; x < map.width(); x++) {
					System.out.print(""
							+ (int) accessor.get(new Position(x, y)) + " ");
				}
				System.out.println();
			}

	}

	public static List<Position> pathToZero(Position p, Accessor accessor) {
		ArrayList<Position> ps = new ArrayList<Position>();
		if (!accessor.passable(p))
			return ps;
		while (accessor.get(p) > 0) {
			p.getNeighbors(neighbors);
			for (int ni = 0; ni < 4; ni++) {
				Position n = neighbors[ni];
				float val = accessor.get(n);
				if (val >= 0 && val < accessor.get(p)) {
					ps.add(new Position(n));
					p = new Position(n);
				}
			}
		}
		if (accessor.passable(p))
			ps.add(new Position(p));

		return ps;
	}
}

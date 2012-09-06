package com.cdm;

import java.util.List;

public class Player extends Entity {

	private final static float SPEED = 0.2f;
	private List<Position> job = null;

	public Player(Position p, Level level) {
		super(p, Entity.ViewType.SHIP, level);
	}

	@Override
	public void move(float delta) {
		if (job != null) {

			while (job.size() > 0 && delta > 0) {
				Position first = job.get(0);
				Position p = getPosition();
				float distance = first.distanceTo(p);
				float distToMove = delta * SPEED;
				if (distance < distToMove) {
					delta -= distance / SPEED;
					p.x = first.x;
					p.y = first.y;
					job.remove(0);
				} else {
					float dx = (first.x - p.x) / distance;
					float dy = (first.x - p.x) / distance;

					p.x += dx * delta * SPEED;
					p.y += dy * delta * SPEED;
					delta = 0;
				}

			}

		}
	}

	public void setJob(List<Position> points) {
		job = points;

	}

}

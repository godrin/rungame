package com.cdm;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

	private final static float SPEED = 0.8f;
	private List<Position> job = new ArrayList<Position>();

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
					float dy = (first.y - p.y) / distance;

					dx *= delta * SPEED;
					dy *= delta * SPEED;

					p.x += dx;
					p.y += dy;
					delta = 0;
				}

			}

		}
	}

	public void setJob(List<Position> points) {
		job.clear();
		job.addAll(points);

	}

}

package com.cdm;

public class Enemy extends Entity {

	private Position nextPosition;

	public Enemy(Position p, Level level) {
		super(p, Entity.ViewType.ENEMY, level);
	}

	@Override
	public void move(float delta) {
		while (delta > 0) {
			if (nextPosition != null) {
				if (getPosition().distance2To(nextPosition) < Position.MIN_DISTANCE) {
					nextPosition = null;
				}
			}
			if (nextPosition == null)
				nextPosition = getNextPosition();
			delta-=1;
		}
	}

	private Position getNextPosition() {
		// TODO Auto-generated method stub
		return null;
	}
}

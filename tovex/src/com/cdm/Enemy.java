package com.cdm;

public class Enemy extends Entity {

	public Enemy(Position p, Level level) {
		super(p, Entity.ViewType.ENEMY, level);
	}

	@Override
	public void move(float delta) {

	}
}

package com.cdm;

public class Player extends Entity {

	public Player(Position p, Level level) {
		super(p, Entity.ViewType.SHIP, level);
	}

	@Override
	public void move(float delta) {
	}

}

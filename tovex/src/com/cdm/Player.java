package com.cdm;

public class Player extends Entity {

	public Player(Position p) {
		super(p, Entity.ViewType.SHIP);
	}

	@Override
	public void move(float delta) {
	}

}

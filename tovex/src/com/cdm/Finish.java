package com.cdm;

public class Finish extends Entity {

	public Finish(Position p, Level level) {
		super(p, Entity.ViewType.FINISH, level);
	}

	@Override
	public void move(float delta) {
	}

}

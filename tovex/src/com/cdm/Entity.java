package com.cdm;

public abstract class Entity {
	private Position pos;
	private ViewType viewType;
	private Level level;

	public enum ViewType {
		ENEMY, SHIP, FINISH
	};

	public Entity(Position p, ViewType pType, Level pLevel) {
		pos = p;
		viewType = pType;
		level = pLevel;
	}

	public Position getPosition() {
		return pos;
	}

	public ViewType getViewType() {
		return viewType;
	}

	public abstract void move(float delta);

}

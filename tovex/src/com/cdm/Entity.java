package com.cdm;

public abstract class Entity {
	private Position pos;
	private ViewType viewType;

	public enum ViewType {
		ENEMY, SHIP, FINISH
	};

	public Entity(Position p, ViewType pType) {
		pos = p;
		viewType = pType;
	}

	public Position getPosition() {
		return pos;
	}

	public ViewType getViewType() {
		return viewType;
	}

	public abstract void move(float delta);

}
